package com.ertugrul.credit.service.impl;

import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.service.UserNotificationService;
import com.ertugrul.credit.service.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsNotificationService implements UserNotificationService {

    private final ValidationService validationService;

    public SmsNotificationService(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public void notifyCustomer(User user, String message) {
        if (validationService.validatePhoneNumber(user.getPhone())) {
            log.info(message);
            log.info("SMS message {} sent to the customer {}", message, user.getNationalIdNumber());
        } else {
            log.warn("Customer phone number is missing or wrong format to send sms notification");
        }
    }
}
