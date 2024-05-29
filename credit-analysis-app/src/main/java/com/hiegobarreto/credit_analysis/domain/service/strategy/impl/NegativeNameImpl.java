package com.hiegobarreto.credit_analysis.domain.service.strategy.impl;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;
import com.hiegobarreto.credit_analysis.domain.service.strategy.PointCalculation;
import com.hiegobarreto.credit_analysis.exception.StrategyException;
import com.hiegobarreto.credit_analysis.utils.MessageConstant;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NegativeNameImpl implements PointCalculation {

    @Override
    public int calculate(Proposal proposal) {
        if(negativeName()){
            throw new StrategyException(String.format(MessageConstant.NEGATIVE_CLIENT, proposal.getUsuario().getNome()));
        }
        return 100;
    }

    private boolean negativeName(){
        return new Random().nextBoolean();
    }
}
