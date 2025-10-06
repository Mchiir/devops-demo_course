package com.rca.demo_course.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyModulusClassTest {
    private MyModulusClass model;

    @BeforeEach
    void setUp() { model = new MyModulusClass(); }

    @Test
    @DisplayName("Modulus of two positive numbers")
    void testModulus_TwoPositiveNumbers() {
        double result = model.modulus(5, 2);
        Assertions.assertEquals(1.0, result);
    }

    @Test
    @DisplayName("Modulus with infinity divisor")
    void testModulus_InfinityDivisor() {
        double result = model.modulus(5, Double.POSITIVE_INFINITY);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Modulus with zero divisor")
    void testModulus_ZeroDivisor() {
        double result = model.modulus(5, 0);
        Assertions.assertTrue(Double.isNaN(result), "Result should be NaN when divisor is zero");
    }

    @Test
    @DisplayName("Modulus with negative infinity divisor")
    void testModulus_NegativeInfinityDivisor() {
        double result = model.modulus(5, Double.NEGATIVE_INFINITY);
        Assertions.assertEquals(5.0, result);
    }
}
