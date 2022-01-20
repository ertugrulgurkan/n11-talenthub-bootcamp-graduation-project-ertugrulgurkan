package com.ertugrul.credit.rule;

import com.ertugrul.credit.dto.CreditCalculationDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreditAmountCalculator {
    List<CreditCalculationRule> calculationRules = new ArrayList<>();

    public CreditAmountCalculator() {
        this.calculationRules.add(new RuleOne());
        this.calculationRules.add(new RuleTwo());
        this.calculationRules.add(new RuleThree());
        this.calculationRules.add(new RuleFour());
    }

    public double getCreditAmount(CreditCalculationDto creditCalculationDto) {
        double creditAmount = 0.0;
        for (CreditCalculationRule calculationRule : calculationRules) {
            creditAmount += calculationRule.calculate(creditCalculationDto);
        }
        return creditAmount;
    }
}
