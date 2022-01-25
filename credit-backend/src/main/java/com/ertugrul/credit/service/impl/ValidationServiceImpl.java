package com.ertugrul.credit.service.impl;

import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.exception.CreditApplicationNotFoundException;
import com.ertugrul.credit.exception.NationalIdNumberNotValidException;
import com.ertugrul.credit.exception.UserAlreadyExistException;
import com.ertugrul.credit.exception.UserNotFoundException;
import com.ertugrul.credit.service.ValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public User validateUser(Optional<User> user) {
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found!");
        }
        return user.get();
    }

    @Override
    public CreditApplication validateCreditApplication(Optional<CreditApplication> creditApplication) {
        if (creditApplication.isEmpty()) {
            throw new CreditApplicationNotFoundException("Credit Application has been found!");
        }
        return creditApplication.get();
    }

    @Override
    public Boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public Boolean validateNationalIdNumber(String nationalIdNumber) {
        Pattern pattern = Pattern.compile("^\\d{11}$");
        Matcher matcher = pattern.matcher(nationalIdNumber);
        if (!matcher.matches())
            throw new NationalIdNumberNotValidException("National Id is not valid");
        return matcher.matches();
    }

    @Override
    public Boolean validateUserNotExist(Optional<User> optionalUser) {
        if (optionalUser.isPresent())
            throw new UserAlreadyExistException("User has already exist.");
        return Boolean.TRUE;
    }

}
