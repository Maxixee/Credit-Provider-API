package com.hiegobarreto.credit_analysis.domain.service;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;
import com.hiegobarreto.credit_analysis.domain.service.strategy.PointCalculation;
import com.hiegobarreto.credit_analysis.exception.StrategyException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditAnalysisService {

    @Autowired
    private List<PointCalculation> pointCalculationList;
    @Autowired
    private RabbitMQNotificationService rabbitMQNotificationService;
    @Value("${rabbitmq.exchange.completed.proposal}")
    private String exchangeCompletedProposal;

    public void toAnalyze(Proposal proposal){
        try{
            int points= pointCalculationList
                    .stream()
                    .mapToInt(impl -> impl.calculate(proposal))
                    .sum();

            proposal.setAprovada(points > 350);
        } catch (StrategyException ex) {
            proposal.setAprovada(false);
            proposal.setObservacao(ex.getMessage());
        }
        rabbitMQNotificationService.notify(exchangeCompletedProposal, proposal);
    }
}
