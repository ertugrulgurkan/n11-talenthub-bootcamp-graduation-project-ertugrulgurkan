package com.ertugrul.credit.service.impl;

import com.ertugrul.credit.service.CreditScoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreditScoreServiceImpl implements CreditScoreService {

    @Override
    public long calculateCreditScore(Double monthlyIncome, String nationalIdNumber) {
        if (monthlyIncome == null || nationalIdNumber == null)
            return 0L;
        long lastDigitOfId = Long.parseLong(nationalIdNumber.substring(nationalIdNumber.length()-1));
        long firstDigitOfId = Long.parseLong(nationalIdNumber.substring(0, 1));
        long creditScore = monthlyIncome.longValue() * Math.abs(lastDigitOfId + 1 + firstDigitOfId) / 100;
        log.info("Credit Score: " + creditScore);
        return creditScore;
    }
}
