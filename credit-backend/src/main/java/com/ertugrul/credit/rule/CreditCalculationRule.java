package com.ertugrul.credit.rule;


import com.ertugrul.credit.entity.CreditApplication;

public interface CreditCalculationRule {

    double calculate(CreditApplication creditApplication);
}
