package com.ertugrul.credit.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserRequestDto implements Serializable {
    @NotBlank(message = "National Id Number is mandatory")
    @Pattern(regexp = "[\\d]{11}", message = "National Id Number should contain 11 digits!")
    private final String nationalIdNumber;
    @Past()
    private final LocalDate birthDate;
    @NotBlank(message = "Name is mandatory")
    private final String name;
    @NotBlank(message = "Surname is mandatory")
    private final String surname;
    @NotBlank(message = "Phone is mandatory")
    private final String phone;
}
