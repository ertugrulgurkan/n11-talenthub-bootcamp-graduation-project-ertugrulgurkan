package com.ertugrul.credit.rule;


public class RuleOne implements CreditCalculationRule {
    @Override
    public double calculate(long creditScore, double monthlyIncome, double assurance) {
        double amount = 0;
        if (creditScore >= 500 && creditScore < 1_000 && monthlyIncome < 5_000) {
            amount = 10_000 + (assurance * 10 / 100);
        }
        return amount;
    }
}
