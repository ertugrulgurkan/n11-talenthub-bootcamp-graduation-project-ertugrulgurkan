package com.ertugrul.credit.service;


import com.ertugrul.credit.dto.CreditApplicationRequestDto;
import com.ertugrul.credit.dto.CreditApplicationResultDto;
import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.enums.CreditApplicationResult;
import com.ertugrul.credit.mapper.CreditApplicationMapper;
import com.ertugrul.credit.rule.CreditAmountCalculator;
import com.ertugrul.credit.service.entityservice.CreditApplicationEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreditApplicationService {
    private final UserService userService;
    private final CreditApplicationEntityService creditApplicationEntityService;
    private final ValidationService validationService;
    private final CreditAmountCalculator creditAmountCalculator;
    private final CreditScoreService creditScoreService;

    @Transactional
    public CreditApplicationResultDto create(CreditApplicationRequestDto creditApplicationRequestDto) {
        CreditApplication creditApplication = CreditApplicationMapper.INSTANCE.convertCreditApplicationRequestDtoToCreditApplication(creditApplicationRequestDto);
        User userFromDto = creditApplication.getUser();
        User user = userService.findUserByNationalIdNumber(userFromDto.getNationalIdNumber());
        fillCreditApplicationEntity(creditApplication, user);
        CreditApplication savedApplication = creditApplicationEntityService.save(creditApplication);
        return CreditApplicationMapper.INSTANCE.convertCreditApplicationToCreditApplicationResultDto(savedApplication);
    }

    private void fillCreditApplicationEntity(CreditApplication creditApplication, User user) {
        Long creditScore = creditScoreService.calculateCreditScore(creditApplication.getMonthlyIncome(), user.getNationalIdNumber());
        creditApplication.setUser(user);
        creditApplication.setApplicationDate(LocalDateTime.now());
        creditApplication.setCreditScore(creditScore);
        double creditAmount = creditAmountCalculator.getCreditLimitAmount(creditApplication);
        CreditApplicationResult creditApplicationResult = creditAmount > 0 ? CreditApplicationResult.APPROVED : CreditApplicationResult.REJECTED;
        creditApplication.setCreditApplicationResult(creditApplicationResult);
        creditApplication.setCreditLimitAmount(creditAmount);
    }


    public List<CreditApplicationResultDto> findCreditApplicationByNationalIdNumberAndBirthDate(String nationalIdNumber, LocalDate birthDate) {
        Optional<List<CreditApplication>> creditApplicationByNationalIdNumberAndBirthDate = creditApplicationEntityService.findCreditApplicationByNationalIdNumberAndBirthDate(nationalIdNumber, birthDate);
        List<CreditApplication> creditApplicationList = validationService.validateCreditApplicationList(creditApplicationByNationalIdNumberAndBirthDate);
        return CreditApplicationMapper.INSTANCE.convertAllCreditApplicationToCreditApplicationResultDto(creditApplicationList);
    }
}
