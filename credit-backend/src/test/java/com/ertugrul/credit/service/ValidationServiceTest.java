package com.ertugrul.credit.service;

import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.exception.CreditApplicationNotFoundException;
import com.ertugrul.credit.exception.NationalIdNumberNotValidException;
import com.ertugrul.credit.exception.UserAlreadyExistException;
import com.ertugrul.credit.exception.UserNotFoundException;
import com.ertugrul.credit.service.impl.ValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class ValidationServiceTest {

    @InjectMocks
    ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new ValidationServiceImpl();
    }

    @Test
    void shouldValidateUser() {
        User user = new User();
        Optional<User> optionalUser = Optional.of(user);
        assertEquals(user, validationService.validateUser(optionalUser));
    }

    @Test
    void shouldNotValidateUser() {
        Optional<User> optionalUser = Optional.empty();
        assertThrows(UserNotFoundException.class,()-> validationService.validateUser(optionalUser));
    }

    @Test
    void shouldValidateCreditApplication() {
        CreditApplication creditApplication = new CreditApplication();
        Optional<CreditApplication> optionalCreditApplication = Optional.of(creditApplication);
        assertEquals(creditApplication, validationService.validateCreditApplication(optionalCreditApplication));
    }

    @Test
    void shouldNotValidateCreditApplication() {
        Optional<CreditApplication> creditApplication = Optional.empty();
        assertThrows(CreditApplicationNotFoundException.class,()-> validationService.validateCreditApplication(creditApplication));
    }

    @Test
    void shouldValidatePhoneNumber() {
        String phone = "5346632260";
        assertEquals(Boolean.TRUE, validationService.validatePhoneNumber(phone));

    }

    @Test
    void shouldNotValidatePhoneNumber() {
        String phone = "abx4-?260";
        assertEquals(Boolean.FALSE,validationService.validatePhoneNumber(phone));
    }


    @Test
    void shouldValidateNationalIdNumber() {
        String nationalId = "13241052426";
        assertEquals(Boolean.TRUE, validationService.validateNationalIdNumber(nationalId));

    }

    @Test
    void shouldNotValidateNationalIdNumber() {
        String nationalIdNumber = "abx4-?260";
        assertThrows(NationalIdNumberNotValidException.class,()-> validationService.validateNationalIdNumber(nationalIdNumber));
    }


    @Test
    void shouldValidateUserNotExist() {
        Optional<User> optionalUser = Optional.empty();
        assertEquals(Boolean.TRUE, validationService.validateUserNotExist(optionalUser));
    }

    @Test
    void shouldNotValidateUserNotExist() {
        Optional<User> optionalUser = Optional.of(new User());
        assertThrows(UserAlreadyExistException.class,()-> validationService.validateUserNotExist(optionalUser));
    }

}