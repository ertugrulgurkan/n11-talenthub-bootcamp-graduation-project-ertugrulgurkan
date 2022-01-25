package com.ertugrul.credit.service.impl;

import com.ertugrul.credit.component.notifyMessage.NotifyMessage;
import com.ertugrul.credit.dto.CreditApplicationRequestDto;
import com.ertugrul.credit.dto.CreditApplicationResultDto;
import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.enums.CreditApplicationResult;
import com.ertugrul.credit.factory.NotifyMessageFactory;
import com.ertugrul.credit.mapper.CreditApplicationMapper;
import com.ertugrul.credit.rule.CreditAmountCalculator;
import com.ertugrul.credit.service.CreditApplicationService;
import com.ertugrul.credit.service.CreditScoreService;
import com.ertugrul.credit.service.UserNotificationService;
import com.ertugrul.credit.service.ValidationService;
import com.ertugrul.credit.service.entityservice.CreditApplicationEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreditApplicationServiceImpl implements CreditApplicationService {
    private final UserServiceImpl userService;
    private final CreditApplicationEntityService creditApplicationEntityService;
    private final ValidationService validationService;
    private final CreditAmountCalculator creditAmountCalculator;
    private final CreditScoreService creditScoreService;
    private final UserNotificationService userNotificationService;

    @Transactional
    @Override
    public CreditApplicationResultDto saveCreditApplication(CreditApplicationRequestDto creditApplicationRequestDto) {
        CreditApplication creditApplication = CreditApplicationMapper.INSTANCE.convertCreditApplicationRequestDtoToCreditApplication(creditApplicationRequestDto);
        saveCreditApplicationUser(creditApplication);
        long creditScore = creditScoreService.calculateCreditScore(creditApplication.getMonthlyIncome(), creditApplication.getUser().getNationalIdNumber());
        double creditAmount = creditAmountCalculator.getCreditLimitAmount(creditScore, creditApplication.getMonthlyIncome(), creditApplication.getAssurance());
        CreditApplicationResult creditApplicationResult = creditAmount > 0 ? CreditApplicationResult.APPROVED : CreditApplicationResult.REJECTED;
        fillCreditApplicationEntity(creditApplication, creditScore, creditAmount, creditApplicationResult);
        CreditApplication savedApplication = saveCreditApplication(creditApplication);
        notifyUser(savedApplication);
        return CreditApplicationMapper.INSTANCE.convertCreditApplicationToCreditApplicationResultDto(savedApplication);
    }

    @Override
    public CreditApplicationResultDto findCreditApplicationByNationalIdNumberAndBirthDate(String nationalIdNumber, LocalDate birthDate) {
        Optional<CreditApplication> creditApplicationByNationalIdNumberAndBirthDate = creditApplicationEntityService.findCreditApplicationByNationalIdNumberAndBirthDate(nationalIdNumber, birthDate);
        CreditApplication creditApplication = validationService.validateCreditApplication(creditApplicationByNationalIdNumberAndBirthDate);
        return CreditApplicationMapper.INSTANCE.convertCreditApplicationToCreditApplicationResultDto(creditApplication);
    }

    private void fillCreditApplicationEntity(CreditApplication creditApplication, long creditScore, double creditAmount, CreditApplicationResult creditApplicationResult) {
        log.info("Credit Application Result: " + creditApplicationResult);
        log.info("Credit Limit Amount: " + creditAmount);
        log.info("Credit Score: " + creditScore);
        creditApplication.setApplicationDate(LocalDateTime.now());
        creditApplication.setCreditScore(creditScore);
        creditApplication.setCreditApplicationResult(creditApplicationResult);
        creditApplication.setCreditLimitAmount(creditAmount);
    }

    private void notifyUser(CreditApplication creditApplication) {
        User user = creditApplication.getUser();
        NotifyMessage notifyMessage = NotifyMessageFactory.getNotifyMessage(creditApplication.getCreditApplicationResult().getResult());
        String generatedMessage = notifyMessage.getMessage(user.getName() + " " + user.getSurname(), creditApplication.getCreditLimitAmount());
        userNotificationService.notifyUser(creditApplication.getUser(), generatedMessage);
    }

    private CreditApplication saveCreditApplication(CreditApplication creditApplication) {
        return creditApplicationEntityService.save(creditApplication);
    }

    private void saveCreditApplicationUser(CreditApplication creditApplication) {
        userService.saveUserToEntity(creditApplication.getUser());
    }

}
