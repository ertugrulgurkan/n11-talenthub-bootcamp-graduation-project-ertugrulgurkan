package com.ertugrul.credit.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditApplicationInquiryDto {
    private final String nationalIdNumber;
    private final LocalDate birthDate;
}
