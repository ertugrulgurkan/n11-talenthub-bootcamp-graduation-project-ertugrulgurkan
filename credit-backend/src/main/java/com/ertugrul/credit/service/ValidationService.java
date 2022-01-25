package com.ertugrul.credit.service;

import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.entity.User;

import java.util.Optional;

public interface ValidationService {
    User validateUser(Optional<User> user);

    CreditApplication validateCreditApplication(Optional<CreditApplication> creditApplication);

    Boolean validatePhoneNumber(String phoneNumber);

    Boolean validateNationalIdNumber(String nationalIdNumber);

    Boolean validateUserNotExist(Optional<User> byNationalIdNumber);
}
