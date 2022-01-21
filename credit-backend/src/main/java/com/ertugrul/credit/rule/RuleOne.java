package com.ertugrul.credit.rule;

import com.ertugrul.credit.entity.CreditApplication;

public class RuleOne implements CreditCalculationRule {
    @Override
    public double calculate(CreditApplication creditApplication) {
        double amount = 0;
        long creditScore = creditApplication.getCreditScore();
        double monthlyIncome = creditApplication.getMonthlyIncome();
        double assurance = creditApplication.getAssurance() == null ? 0 : creditApplication.getAssurance();

        if (creditScore >= 500 && creditScore < 1_000 && monthlyIncome < 5_000) {
            amount = 10_000 + (assurance * 10 / 100);
        }
        return amount;
    }
}
