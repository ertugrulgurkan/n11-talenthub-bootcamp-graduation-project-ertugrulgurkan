package com.ertugrul.credit.service;

import com.ertugrul.credit.component.notifyMessage.ApprovedNotifyMessage;
import com.ertugrul.credit.component.notifyMessage.NotifyMessage;
import com.ertugrul.credit.component.notifyMessage.RejectedNotifyMessage;
import com.ertugrul.credit.dto.CreditApplicationRequestDto;
import com.ertugrul.credit.dto.CreditApplicationResultDto;
import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.enums.CreditApplicationResult;
import com.ertugrul.credit.factory.NotifyMessageFactory;
import com.ertugrul.credit.mapper.CreditApplicationMapper;
import com.ertugrul.credit.rule.CreditAmountCalculator;
import com.ertugrul.credit.service.entityservice.CreditApplicationEntityService;
import com.ertugrul.credit.service.impl.CreditApplicationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditApplicationServiceTest {
    @Mock
    UserService userService;
    @Mock
    CreditApplicationEntityService creditApplicationEntityService;
    @Mock
    ValidationService validationService;
    @Mock
    CreditAmountCalculator creditAmountCalculator;
    @Mock
    CreditScoreService creditScoreService;
    @Mock
    UserNotificationService userNotificationService;
    @Mock
    NotifyMessageFactory notifyMessageFactory;

    @InjectMocks
    CreditApplicationServiceImpl creditApplicationService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void saveApprovedCreditApplication() {
        CreditApplication expectedCreditApplication = getApprovedCreditApplication();
        saveCreditApplication(expectedCreditApplication);
    }


    @Test
    void saveRejectedCreditApplication() {
        CreditApplication expectedCreditApplication = getRejectedCreditApplication();
        saveCreditApplication(expectedCreditApplication);
    }


    @Test
    void findCreditApplicationByNationalIdNumberAndBirthDate() {
        CreditApplication expectedCreditApplication = getApprovedCreditApplication();

        when(creditApplicationEntityService.findCreditApplicationByNationalIdNumberAndBirthDate(expectedCreditApplication.getUser().getNationalIdNumber(), expectedCreditApplication.getUser().getBirthDate())).thenReturn(Optional.of(expectedCreditApplication));
        when(validationService.validateCreditApplication(Optional.of(expectedCreditApplication))).thenReturn(expectedCreditApplication);

        CreditApplicationResultDto expected = CreditApplicationMapper.INSTANCE.convertCreditApplicationToCreditApplicationResultDto(expectedCreditApplication);

        CreditApplicationResultDto actual = creditApplicationService.findCreditApplicationByNationalIdNumberAndBirthDate(expectedCreditApplication.getUser().getNationalIdNumber(), expectedCreditApplication.getUser().getBirthDate());
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }



    private void saveCreditApplication(CreditApplication expectedCreditApplication) {
        initNotifyFactory();
        CreditApplicationRequestDto creditApplicationRequestDto = CreditApplicationMapper.INSTANCE.convertCreditApplicationToCreditApplicationRequestDto(expectedCreditApplication);
        when(userService.saveUserToEntity(any())).thenReturn(expectedCreditApplication.getUser());
        when(creditScoreService.calculateCreditScore(expectedCreditApplication.getMonthlyIncome(), expectedCreditApplication.getUser().getNationalIdNumber())).thenReturn(expectedCreditApplication.getCreditScore());
        when(creditAmountCalculator.getCreditLimitAmount(expectedCreditApplication.getCreditScore(), expectedCreditApplication.getMonthlyIncome(), expectedCreditApplication.getAssurance())).thenReturn(expectedCreditApplication.getCreditLimitAmount());
        when(creditApplicationEntityService.save(any(CreditApplication.class))).thenReturn(expectedCreditApplication);
        CreditApplicationResultDto expected = CreditApplicationMapper.INSTANCE.convertCreditApplicationToCreditApplicationResultDto(expectedCreditApplication);
        CreditApplicationResultDto actual = creditApplicationService.saveCreditApplication(creditApplicationRequestDto);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual)
        );
    }

    private User getUser() {
        User user1 = new User();
        user1.setId(1L);
        user1.setNationalIdNumber("13241052420");
        user1.setPhone("53477658837");
        user1.setName("Ahmet");
        user1.setBirthDate(LocalDate.of(2022, 1, 25));
        return user1;
    }


    private CreditApplication getApprovedCreditApplication() {
        CreditApplication creditApplication = new CreditApplication();
        creditApplication.setUser(getUser());
        creditApplication.setCreditScore(750L);
        creditApplication.setMonthlyIncome(12000.0);
        creditApplication.setCreditApplicationResult(CreditApplicationResult.APPROVED);
        creditApplication.setCreditLimitAmount(35000.0);
        return creditApplication;
    }

    private CreditApplication getRejectedCreditApplication() {
        CreditApplication creditApplication = new CreditApplication();
        creditApplication.setUser(getUser());
        creditApplication.setCreditScore(300L);
        creditApplication.setMonthlyIncome(12000.0);
        creditApplication.setCreditApplicationResult(CreditApplicationResult.REJECTED);
        creditApplication.setCreditLimitAmount(0.0);
        return creditApplication;
    }

    private void initNotifyFactory() {
        List<NotifyMessage> notifyMessages = new ArrayList<>();
        notifyMessages.add(new ApprovedNotifyMessage());
        notifyMessages.add(new RejectedNotifyMessage());
        notifyMessageFactory = new NotifyMessageFactory(notifyMessages);
        notifyMessageFactory.initNotifyMessageCache();
    }

}