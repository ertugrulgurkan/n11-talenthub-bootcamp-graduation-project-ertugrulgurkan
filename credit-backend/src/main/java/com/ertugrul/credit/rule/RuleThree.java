package com.ertugrul.credit.rule;

import com.ertugrul.credit.dto.CreditCalculationDto;
import com.ertugrul.credit.util.Constant;

public class RuleThree implements CreditCalculationRule {
    @Override
    public double calculate(CreditCalculationDto creditCalculationDto) {
        double amount = 0;
        long creditScore = creditCalculationDto.getCreditScore();
        double monthlyIncome = creditCalculationDto.getMonthlyIncome();
        double assurance = creditCalculationDto.getAssurance();

        if (creditScore >= 500 && creditScore < 1_000 && monthlyIncome > 10_000) {
            amount = (monthlyIncome * Constant.CREDIT_LIMIT_MULTIPLIER / 2) + (assurance * 25 / 100);
        }
        return amount;
    }
}
