package com.ertugrul.credit.rule;

import com.ertugrul.credit.util.Constant;

public class RuleFour implements CreditCalculationRule {
    @Override
    public double calculate( long creditScore, double monthlyIncome, double assurance) {
        double amount = 0;
        if (creditScore >= 1_000) {
            amount = (monthlyIncome * Constant.CREDIT_LIMIT_MULTIPLIER) + (assurance * 50 / 100);
        }
        return amount;
    }
}
