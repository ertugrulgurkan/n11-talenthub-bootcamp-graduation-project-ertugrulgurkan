package com.ertugrul.credit.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserRequestDto implements Serializable {
    private final String nationalIdNumber;
    private final LocalDate birthDate;
    private final String name;
    private final String surname;
    private final String phone;
}
