package com.ertugrul.credit.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreditCalculationDto {
    private final double monthlyIncome;
    private final double assurance;
    private final long creditScore;
}
