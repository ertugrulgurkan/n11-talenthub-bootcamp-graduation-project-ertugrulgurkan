package com.ertugrul.credit.rule;

import com.ertugrul.credit.dto.CreditCalculationDto;
import com.ertugrul.credit.util.Constant;

public class RuleFour implements CreditCalculationRule {
    @Override
    public double calculate(CreditCalculationDto creditCalculationDto) {
        double amount = 0;
        long creditScore = creditCalculationDto.getCreditScore();
        double monthlyIncome = creditCalculationDto.getMonthlyIncome();
        double assurance = creditCalculationDto.getAssurance();

        if (creditScore >= 1_000) {
            amount = (monthlyIncome * Constant.CREDIT_LIMIT_MULTIPLIER) + (assurance * 50 / 100);
        }
        return amount;
    }
}
