package com.ertugrul.credit.service;

import com.ertugrul.credit.service.impl.CreditScoreServiceImpl;
import com.ertugrul.credit.service.impl.ValidationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CreditScoreServiceTest {

    @InjectMocks
    CreditScoreService creditScoreService;

    @BeforeEach
    void setUp() {
        creditScoreService = mock(CreditScoreServiceImpl.class);
    }

    @Test
    void shouldCalculateCreditScoreZeroWithNullParams() {
        when(creditScoreService.calculateCreditScore(null, null)).thenReturn(0L);
    }

    @Test
    void shouldCalculateCreditScoreZeroZeroNullParams() {
        when(creditScoreService.calculateCreditScore((double) 0L, "13241052420")).thenReturn(0L);
    }
}