package com.ertugrul.credit.service;

import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.service.impl.SmsNotificationService;
import com.ertugrul.credit.service.impl.ValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

class UserNotificationServiceTest {

    @Mock
    ValidationService validationService;

    @InjectMocks
    UserNotificationService userNotificationService;

    @BeforeEach
    void setUp() {
        validationService = mock(ValidationServiceImpl.class);
        userNotificationService = new SmsNotificationService(validationService);
    }

    @Test
    void notifyUser() {
        User user = new User();
        String smsMessage = "Dummy message";
        user.setPhone("5346632258");
        user.setNationalIdNumber("5346632258");

        userNotificationService.notifyUser(user, smsMessage);

        verify(validationService, times(1)).validatePhoneNumber(user.getPhone());

        when(validationService.validatePhoneNumber(user.getPhone())).thenReturn(true);
    }

    @Test
    void shouldNotNotifyUser() {
        User user = new User();
        String smsMessage = "Dummy message";
        user.setPhone("53?-asda645");
        user.setNationalIdNumber("5346632258");
        userNotificationService.notifyUser(user, smsMessage);

        verify(validationService, times(1)).validatePhoneNumber(user.getPhone());

        when(validationService.validatePhoneNumber(user.getPhone())).thenReturn(false);
    }

}