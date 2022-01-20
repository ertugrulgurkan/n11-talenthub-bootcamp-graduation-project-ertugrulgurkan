package com.ertugrul.credit.rule;


import com.ertugrul.credit.dto.CreditCalculationDto;

public interface CreditCalculationRule {

    double calculate(CreditCalculationDto creditCalculationDto);
}
