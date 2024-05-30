package com.hiegobarreto.proposalapp.listener;

import com.hiegobarreto.proposalapp.domain.entities.Proposal;
import com.hiegobarreto.proposalapp.domain.repository.ProposalRepository;
import com.hiegobarreto.proposalapp.domain.service.WebSocketService;
import com.hiegobarreto.proposalapp.dto.ProposalResponseDto;
import com.hiegobarreto.proposalapp.mapper.ProposalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompletedProposalListener {

    private final ProposalRepository proposalRepository;

    private final WebSocketService webSocketService;

    @RabbitListener(queues = "${rabbitmq.queue.completed.proposal}")
    public void completedProposal(Proposal proposal){
        updateProposal(proposal);
        ProposalResponseDto responseDto = ProposalMapper.INSTANCE.convertEntityToDto(proposal);
        webSocketService.notify(responseDto);
    }

    private void updateProposal(Proposal proposal){
        proposalRepository.updateProposal(proposal.getId(), proposal.getAprovada(), proposal.getObservacao());
    }
}
