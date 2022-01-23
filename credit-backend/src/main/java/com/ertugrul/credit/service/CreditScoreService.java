package com.ertugrul.credit.service;

public interface CreditScoreService {
    Long calculateCreditScore(Double monthlyIncome, String nationalIdNumber);
}
