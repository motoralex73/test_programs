package com.example.testmockitoservice.util;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

class CalculatorTest {
    @Test
    void sumTest() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(11+12, calculator.sum(11,12));
    }

    @Test
    void evenOrNotTest() {
        Assertions.assertTrue(new Calculator().evenOrNot(12));
    }

    @Test
    void devideByZeroTest() throws ExecutionException {
        Assertions.assertThrows(ArithmeticException.class, () -> new Calculator().devide(15,0));
    }
}