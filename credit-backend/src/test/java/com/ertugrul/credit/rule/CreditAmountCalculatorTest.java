package com.ertugrul.credit.rule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditAmountCalculatorTest {

    CreditAmountCalculator creditAmountCalculator;


    @BeforeEach
    void setUp() {
        creditAmountCalculator = new CreditAmountCalculator();
    }

    @Test
    void getCreditLimitAmountRuleZero() {
        double expected = 0.0;
        double actual1 = creditAmountCalculator.getCreditLimitAmount(null, null, null);
        double actual2 = creditAmountCalculator.getCreditLimitAmount(0L, 5000.0, null);
        double actual3 = creditAmountCalculator.getCreditLimitAmount(450L, 15000.0, null);
        double actual4 = creditAmountCalculator.getCreditLimitAmount(450L, 15000.0, null);
        double actual5 = creditAmountCalculator.getCreditLimitAmount(-100L, null, null);
        double actual6 = creditAmountCalculator.getCreditLimitAmount(-100L, -5000.0, null);

        assertAll(
                () -> assertEquals(expected, actual1),
                () -> assertEquals(expected, actual2),
                () -> assertEquals(expected, actual3),
                () -> assertEquals(expected, actual4),
                () -> assertEquals(expected, actual5),
                () -> assertEquals(expected, actual6)
        );
    }

    @Test
    void getCreditLimitAmountRuleOne() {
        double expected1 = 10_000;
        double expected2 = 11_000;

        double actual1 = creditAmountCalculator.getCreditLimitAmount(500L, 2000.0, null);
        double actual2 = creditAmountCalculator.getCreditLimitAmount(800L, 3000.0, 10000.0);
        assertAll(
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2)

        );
    }

    @Test
    void getCreditLimitAmountRuleTwo() {
        double expected1 = 20_000;
        double expected2 = 22_000;

        double actual1 = creditAmountCalculator.getCreditLimitAmount(500L, 6000.0, null);
        double actual2 = creditAmountCalculator.getCreditLimitAmount(800L, 9000.0, 10000.0);
        assertAll(
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2)

        );
    }

    @Test
    void getCreditLimitAmountRuleThree() {
        double expected1 = 32_000;
        double expected2 = 38_500;

        double actual1 = creditAmountCalculator.getCreditLimitAmount(500L, 16000.0, null);
        double actual2 = creditAmountCalculator.getCreditLimitAmount(800L, 18000.0, 10000.0);
        assertAll(
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2)

        );
    }

    @Test
    void getCreditLimitAmountRuleFour() {
        double expected1 = 64_000;
        double expected2 = 77_000;

        double actual1 = creditAmountCalculator.getCreditLimitAmount(1200L, 16000.0, null);
        double actual2 = creditAmountCalculator.getCreditLimitAmount(1000L, 18000.0, 10000.0);
        assertAll(
                () -> assertEquals(expected1, actual1),
                () -> assertEquals(expected2, actual2)

        );
    }

}