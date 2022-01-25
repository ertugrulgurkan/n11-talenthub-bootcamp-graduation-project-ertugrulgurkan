package com.ertugrul.credit.service;

import com.ertugrul.credit.service.impl.CreditScoreServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;

class CreditScoreServiceTest {

    @InjectMocks
    CreditScoreService creditScoreService;

    @BeforeEach
    void setUp() {
        creditScoreService = new CreditScoreServiceImpl();
    }

    @Test
    void shouldCalculateCreditScoreZeroWithNullParams() {
        assertEquals( 0L, creditScoreService.calculateCreditScore((double) 0L, null));
    }

    @Test
    void shouldCalculateCreditScoreWithZeroIncomeParam() {
        assertEquals( 0L, creditScoreService.calculateCreditScore((double) 0L, "13241052420"));
    }
    @Test
    void shouldCalculateCreditScore() {
        long l = creditScoreService.calculateCreditScore((double) 15000, "13241052425");
        assertTrue(l > 0);
    }
}