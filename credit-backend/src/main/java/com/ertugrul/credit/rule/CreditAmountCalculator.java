package com.ertugrul.credit.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Rule Pattern for CreditAmount Calculation
 */
@Component
@Slf4j
public class CreditAmountCalculator {
    List<CreditCalculationRule> calculationRules = new ArrayList<>();

    public CreditAmountCalculator() {
        this.calculationRules.add(new RuleOne());
        this.calculationRules.add(new RuleTwo());
        this.calculationRules.add(new RuleThree());
        this.calculationRules.add(new RuleFour());
    }

    public double getCreditLimitAmount(Long creditScore, Double monthlyIncome, Double creditAssurance) {
        double creditAmount = 0.0;
        if (creditScore == null || monthlyIncome == null)
            return creditAmount;
        double assurance = creditAssurance == null ? 0 : creditAssurance;
        for (CreditCalculationRule calculationRule : calculationRules) {
            creditAmount += calculationRule.calculate(creditScore, monthlyIncome, assurance);
        }
        log.info("creditAmount: " + creditAmount);
        return creditAmount;
    }
}
