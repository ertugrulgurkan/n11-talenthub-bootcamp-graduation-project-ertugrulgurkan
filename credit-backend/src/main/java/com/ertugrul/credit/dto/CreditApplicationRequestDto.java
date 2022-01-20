package com.ertugrul.credit.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class CreditApplicationRequestDto implements Serializable {
    @NotBlank(message = "National Id Number is mandatory")
    @Pattern(regexp = "[\\d]{11}", message = "National Id Number should contain 11 digits!")
    private final String userNationalIdNumber;
    private final Double assurance;
    @NotNull(message = "Monthly Income is mandatory")
    private final Double monthlyIncome;
}
