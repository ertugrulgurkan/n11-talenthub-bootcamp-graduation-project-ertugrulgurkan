package com.ertugrul.credit.rule;

import com.ertugrul.credit.dto.CreditCalculationDto;

public class RuleTwo implements CreditCalculationRule{
    @Override
    public double calculate(CreditCalculationDto creditCalculationDto) {
        double amount = 0;
        long creditScore = creditCalculationDto.getCreditScore();
        double monthlyIncome = creditCalculationDto.getMonthlyIncome();
        double assurance = creditCalculationDto.getAssurance();

        if(creditScore >=500 && creditScore<1_000 && monthlyIncome > 5_000 && monthlyIncome < 10_000){
            amount = 20_000 + (assurance * 20 / 100);
        }
        return amount;
    }
}
