package com.hiegobarreto.credit_analysis.domain.service.strategy.impl;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;
import com.hiegobarreto.credit_analysis.domain.service.strategy.PointCalculation;
import org.springframework.stereotype.Component;

@Component
public class PaymentPeriodLessThanTenYearsImpl implements PointCalculation {

    @Override
    public int calculate(Proposal proposal) {
        return proposal.getPrazoPagamento() < 120 ? 80 : 0;
    }
}
