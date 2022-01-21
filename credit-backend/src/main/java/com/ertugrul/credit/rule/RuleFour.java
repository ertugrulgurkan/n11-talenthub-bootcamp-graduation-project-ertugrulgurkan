package com.ertugrul.credit.rule;

import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.util.Constant;

public class RuleFour implements CreditCalculationRule {
    @Override
    public double calculate(CreditApplication creditApplication) {
        double amount = 0;
        long creditScore = creditApplication.getCreditScore();
        double monthlyIncome = creditApplication.getMonthlyIncome();
        double assurance = creditApplication.getAssurance() == null ? 0 : creditApplication.getAssurance();

        if (creditScore >= 1_000) {
            amount = (monthlyIncome * Constant.CREDIT_LIMIT_MULTIPLIER) + (assurance * 50 / 100);
        }
        return amount;
    }
}
