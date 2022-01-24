package com.ertugrul.credit.service;

public interface CreditScoreService {
    long calculateCreditScore(Double monthlyIncome, String nationalIdNumber);
}
