package com.ertugrul.credit.service.impl;

import com.ertugrul.credit.service.CreditScoreService;
import org.springframework.stereotype.Service;

@Service
public class CreditScoreServiceImpl implements CreditScoreService {

    @Override
    public Long calculateCreditScore(Double monthlyIncome, String nationalIdNumber) {
        //todo imp the method;
        return 1000L;
    }
}
