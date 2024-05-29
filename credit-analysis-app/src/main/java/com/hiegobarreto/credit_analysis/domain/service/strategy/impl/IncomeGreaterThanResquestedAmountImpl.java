package com.hiegobarreto.credit_analysis.domain.service.strategy.impl;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;
import com.hiegobarreto.credit_analysis.domain.service.strategy.PointCalculation;
import org.springframework.stereotype.Component;

@Component
public class IncomeGreaterThanResquestedAmountImpl implements PointCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return incomeGreaterThanResquestedAmount(proposal) ? 100 : 0;
    }

    private boolean incomeGreaterThanResquestedAmount(Proposal proposal){
        return proposal.getUsuario().getRenda() > proposal.getValorSolicitado();
    }
}
