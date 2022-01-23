package com.ertugrul.credit.rule;


public interface CreditCalculationRule {
    double calculate(long creditScore, double monthlyIncome, double assurance);
}
