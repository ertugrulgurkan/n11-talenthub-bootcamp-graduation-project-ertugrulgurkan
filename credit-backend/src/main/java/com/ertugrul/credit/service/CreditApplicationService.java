package com.ertugrul.credit.service;


import com.ertugrul.credit.dto.CreditApplicationRequestDto;
import com.ertugrul.credit.dto.CreditApplicationResponseDto;
import com.ertugrul.credit.entity.CreditApplication;
import com.ertugrul.credit.entity.User;
import com.ertugrul.credit.enums.CreditApplicationResult;
import com.ertugrul.credit.mapper.CreditApplicationMapper;
import com.ertugrul.credit.rule.CreditAmountCalculator;
import com.ertugrul.credit.service.entityservice.CreditApplicationEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditApplicationService {
    private final UserService userService;
    private final CreditApplicationEntityService creditApplicationEntityService;
    private final ValidationService validationService;
    private final CreditAmountCalculator creditAmountCalculator;
    private final CreditScoreService creditScoreService;

    @Transactional
    public CreditApplicationResponseDto create(CreditApplicationRequestDto creditApplicationRequestDto) {
        CreditApplication creditApplication = CreditApplicationMapper.INSTANCE.convertCreditApplicationRequestDtoToCreditApplication(creditApplicationRequestDto);
        User user = creditApplication.getUser();
        user = userService.findUserByNationalIdNumber(user.getNationalIdNumber());
        Long creditScore = creditScoreService.calculateCreditScore(creditApplication.getMonthlyIncome(), user.getNationalIdNumber());
        creditApplication.setUser(user);
        creditApplication.setApplicationDate(LocalDateTime.now());
        creditApplication.setCreditScore(creditScore);
        calculateCreditLimit(creditApplication);
        CreditApplication savedApplication = creditApplicationEntityService.save(creditApplication);
        return CreditApplicationMapper.INSTANCE.convertCreditApplicationResponseDtoToCreditApplication(savedApplication);
    }

    private void calculateCreditLimit(CreditApplication creditApplication) {
        double creditAmount = creditAmountCalculator.getCreditLimitAmount(creditApplication);
        CreditApplicationResult creditApplicationResult = creditAmount > 0 ? CreditApplicationResult.APPROVED : CreditApplicationResult.REJECTED;
        creditApplication.setCreditApplicationResult(creditApplicationResult);
        creditApplication.setCreditLimitAmount(creditAmount);
    }

    public CreditApplicationResponseDto findById(Long id) {
        CreditApplication creditApplicationById = findCreditApplicationById(id);
        return CreditApplicationMapper.INSTANCE.convertCreditApplicationResponseDtoToCreditApplication(creditApplicationById);
    }

    @Transactional
    public void deleteById(Long id) {
        CreditApplication creditApplication = findCreditApplicationById(id);
        creditApplicationEntityService.delete(creditApplication);
    }

    private CreditApplication findCreditApplicationById(Long id) {
        Optional<CreditApplication> creditApplicationById = creditApplicationEntityService.findById(id);
        return validationService.validateCreditApplication(creditApplicationById);
    }

    public List<CreditApplicationResponseDto> findAll() {

        List<CreditApplication> creditApplicationList = creditApplicationEntityService.findAll();

        return CreditApplicationMapper.INSTANCE.convertAllCreditApplicationToCreditApplicationResponseDto(creditApplicationList);
    }


}
