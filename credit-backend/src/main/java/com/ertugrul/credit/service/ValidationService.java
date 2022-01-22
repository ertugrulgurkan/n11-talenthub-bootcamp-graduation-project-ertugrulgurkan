package com.ertugrul.credit.service;

import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.exception.CreditApplicationNotFoundException;
import com.ertugrul.credit.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ValidationService {

    public User validateUser(Optional<User> user) {
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found!");
        }
        return user.get();
    }

    public List<CreditApplication> validateCreditApplicationList(Optional<List<CreditApplication>> creditApplicationList) {
        if (creditApplicationList.isEmpty()) {
            throw new CreditApplicationNotFoundException("No Credit Application has been found!");
        }
        return creditApplicationList.get();
    }
}
