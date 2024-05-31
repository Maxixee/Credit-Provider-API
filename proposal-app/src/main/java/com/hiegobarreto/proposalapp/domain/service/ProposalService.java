package com.hiegobarreto.proposalapp.domain.service;

import com.hiegobarreto.proposalapp.domain.entities.Proposal;
import com.hiegobarreto.proposalapp.domain.repository.ProposalRepository;
import com.hiegobarreto.proposalapp.dto.ProposalRequestDto;
import com.hiegobarreto.proposalapp.dto.ProposalResponseDto;
import com.hiegobarreto.proposalapp.mapper.ProposalMapper;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProposalService {

    private final ProposalRepository proposalRepository;
    private final NotificationRabbitService notificationRabbitService;
    private String exchange;

    public ProposalService(ProposalRepository proposalRepository,
                           NotificationRabbitService notificationRabbitService,
                           @Value("${rabbitmq.pendingproposal.exchange}") String exchange) {
        this.proposalRepository = proposalRepository;
        this.notificationRabbitService = notificationRabbitService;
        this.exchange = exchange;
    }


    @Transactional
    public ProposalResponseDto create(ProposalRequestDto responseDto){
        Proposal proposal = ProposalMapper.INSTANCE.convertDtoToProposal(responseDto);
        proposalRepository.save(proposal);

        int priority = proposal.getUsuario().getRenda() > 10000 ? 10 : 5;
        MessagePostProcessor messagePostProcessor = message -> {
            message.getMessageProperties().setPriority(priority);
            return message;
        };

        notifyRabbitMQ(proposal, messagePostProcessor);

        return ProposalMapper.INSTANCE.convertEntityToDto(proposal);
    }

    @Transactional(readOnly = true)
    public List<ProposalResponseDto> getAll() {
        return ProposalMapper.INSTANCE.convertListEntityToListDto(proposalRepository.findAll());
    }

    private void notifyRabbitMQ(Proposal proposal, MessagePostProcessor messagePostProcessor){
        try {
            notificationRabbitService.notify(proposal, exchange, messagePostProcessor);
        } catch (RuntimeException ex){
            proposal.setIntegrada(false);
            proposalRepository.save(proposal);
        }
    }
}
