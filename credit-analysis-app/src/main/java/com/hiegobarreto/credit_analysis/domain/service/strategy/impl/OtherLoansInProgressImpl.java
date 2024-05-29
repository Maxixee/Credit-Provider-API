package com.hiegobarreto.credit_analysis.domain.service.strategy.impl;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;
import com.hiegobarreto.credit_analysis.domain.service.strategy.PointCalculation;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtherLoansInProgressImpl implements PointCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return otherLoansInProgress() ? 0 : 80;
    }

    private boolean otherLoansInProgress(){
        return new Random().nextBoolean();
    }
}
