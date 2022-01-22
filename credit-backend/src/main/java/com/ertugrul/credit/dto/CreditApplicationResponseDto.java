package com.ertugrul.credit.dto;

import com.ertugrul.credit.enums.CreditApplicationResult;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreditApplicationResponseDto implements Serializable {
    private final String nationalIdNumber;
    private final LocalDate birthDate;
    private final String name;
    private final String surname;
    private final String phone;
    private final Double monthlyIncome;
    private final Double creditLimitAmount;
    private final Double assurance;
    private final LocalDateTime applicationDate;
    private final CreditApplicationResult creditApplicationResult;
}
