package com.ertugrul.credit.rule;

import com.ertugrul.credit.util.Constant;

public class RuleThree implements CreditCalculationRule {
    @Override
    public double calculate( long creditScore, double monthlyIncome, double assurance) {
        double amount = 0;
        if (creditScore >= 500 && creditScore < 1_000 && monthlyIncome > 10_000) {
            amount = (monthlyIncome * Constant.CREDIT_LIMIT_MULTIPLIER / 2) + (assurance * 25 / 100);
        }
        return amount;
    }
}
