package com.hiegobarreto.credit_analysis.listener;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;
import com.hiegobarreto.credit_analysis.domain.service.CreditAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class AnalisysProposalListener {

    private final CreditAnalysisService creditAnalysisService;

    @RabbitListener(queues = "${rabbitmq.queue.pending.proposal}")
    public void analysisProposal(Proposal proposal){
        creditAnalysisService.toAnalyze(proposal);
    }
}
