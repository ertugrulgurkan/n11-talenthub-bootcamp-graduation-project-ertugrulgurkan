package com.ertugrul.credit.dto;

import com.ertugrul.credit.enums.CreditApplicationResult;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CreditApplicationResultDto implements Serializable {
    private final String userNationalIdNumber;
    private final Double creditLimitAmount;
    private final LocalDateTime applicationDate;
    private final CreditApplicationResult creditApplicationResult;
}
