package com.hiegobarreto.credit_analysis.domain.service.strategy.impl;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;
import com.hiegobarreto.credit_analysis.domain.service.strategy.PointCalculation;
import com.hiegobarreto.credit_analysis.exception.StrategyException;
import com.hiegobarreto.credit_analysis.utils.MessageConstant;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PunctuationScoreImpl implements PointCalculation {

    @Override
    public int calculate(Proposal proposal) {
        int score = score();

        if(score < 200){
            throw new StrategyException(String.format(MessageConstant.LOW_SCORE, proposal.getUsuario().getNome()));
        } else if (score <= 400) {
            return 150;
        } else if (score <= 600) {
            return 180;
        } else {
            return 220;
        }
    }

    private int score(){
        return new Random().nextInt(0, 1000);
    }
}
