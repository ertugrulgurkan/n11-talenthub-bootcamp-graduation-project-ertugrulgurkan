package com.ertugrul.credit.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserUpdateRequestDto implements Serializable {
    private final LocalDate birthDate;
    private final String name;
    private final String surname;
    private final String phone;
}
