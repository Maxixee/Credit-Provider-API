package com.hiegobarreto.credit_analysis.domain.service.strategy;

import com.hiegobarreto.credit_analysis.domain.entities.Proposal;

public interface PointCalculation {

    int calculate(Proposal proposal);
}
