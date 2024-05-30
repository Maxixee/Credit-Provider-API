package com.hiegobarreto.notificationapp.listener;

import com.hiegobarreto.notificationapp.domain.entities.Proposal;
import com.hiegobarreto.notificationapp.domain.service.NotificationSnsService;
import com.hiegobarreto.notificationapp.utils.MessageConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PendingProposalListener {

    private final NotificationSnsService notificationSnsService;

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void pendingProposal(Proposal proposal){
        String message = String.format(MessageConstant.PROPOSAL_ANALYSIS, proposal.getUsuario().getNome());
        notificationSnsService.notify(proposal.getUsuario().getTelefone(), message);
    }

    @RabbitListener(queues = "${rabbitmq.queue.completed.proposal}")
    public void completedProposal(Proposal proposal){

        String message;

        if(proposal.getAprovada()){
            message = String.format(MessageConstant.PROPOSAL_APPROVED, proposal.getUsuario().getNome());
        }else{
            message = String.format(MessageConstant.PROPOSAL_DENIED, proposal.getUsuario().getNome(), proposal.getObservacao());
        }

        notificationSnsService.notify(proposal.getUsuario().getTelefone(), message);
    }
}
