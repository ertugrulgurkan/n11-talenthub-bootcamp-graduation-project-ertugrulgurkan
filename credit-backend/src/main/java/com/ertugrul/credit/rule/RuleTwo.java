package com.ertugrul.credit.rule;

public class RuleTwo implements CreditCalculationRule {
    @Override
    public double calculate( long creditScore, double monthlyIncome, double assurance) {
        double amount = 0;
        if (creditScore >= 500 && creditScore < 1_000 && monthlyIncome > 5_000 && monthlyIncome < 10_000) {
            return 20_000 + (assurance * 20 / 100);
        }
        return amount;
    }
}