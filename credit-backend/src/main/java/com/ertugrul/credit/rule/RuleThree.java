package com.ertugrul.credit.rule;

import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.util.Constant;

public class RuleThree implements CreditCalculationRule {
    @Override
    public double calculate(CreditApplication creditApplication) {
        double amount = 0;
        long creditScore = creditApplication.getCreditScore();
        double monthlyIncome = creditApplication.getMonthlyIncome();
        double assurance = creditApplication.getAssurance();

        if (creditScore >= 500 && creditScore < 1_000 && monthlyIncome > 10_000) {
            amount = (monthlyIncome * Constant.CREDIT_LIMIT_MULTIPLIER / 2) + (assurance * 25 / 100);
        }
        return amount;
    }
}
