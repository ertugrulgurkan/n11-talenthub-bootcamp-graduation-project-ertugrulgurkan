package com.ertugrul.credit.rule;

import com.ertugrul.credit.entity.CreditApplication;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Rule Pattern for CreditAmount Calculation
 */
@Component
public class CreditAmountCalculator {
    List<CreditCalculationRule> calculationRules = new ArrayList<>();

    public CreditAmountCalculator() {
        this.calculationRules.add(new RuleOne());
        this.calculationRules.add(new RuleTwo());
        this.calculationRules.add(new RuleThree());
        this.calculationRules.add(new RuleFour());
    }

    public double getCreditLimitAmount(CreditApplication creditApplication) {
        double creditAmount = 0.0;
        long creditScore = creditApplication.getCreditScore() == null ? 0 : creditApplication.getCreditScore();
        double monthlyIncome = creditApplication.getMonthlyIncome() == null ? 0 : creditApplication.getMonthlyIncome();
        double assurance = creditApplication.getAssurance() == null ? 0 : creditApplication.getAssurance();
        for (CreditCalculationRule calculationRule : calculationRules) {
            creditAmount += calculationRule.calculate(creditScore, monthlyIncome, assurance);
        }
        return creditAmount;
    }
}
