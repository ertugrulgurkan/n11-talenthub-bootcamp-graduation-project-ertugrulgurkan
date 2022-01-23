package com.ertugrul.credit.service.impl;

import com.ertugrul.credit.service.CreditScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditScoreServiceImpl implements CreditScoreService {

    @Override
    public Long calculateCreditScore(Double monthlyIncome, String nationalIdNumber) {
        Long lastDigitOfId = Long.valueOf(nationalIdNumber.substring(10));
        Long firstDigitOfId = Long.valueOf(nationalIdNumber.substring(0, 1));
        long creditScore = monthlyIncome.longValue() * Math.abs(lastDigitOfId + firstDigitOfId) / 100;
        log.info("Credit Score: " + creditScore);
        return creditScore;
    }
}
