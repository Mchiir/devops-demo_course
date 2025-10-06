package com.rca.demo_course.service;

import com.rca.demo_course.service.impl.MyModulusServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@DisplayName("MyModulus Service Tests")
public class MyModulusServiceTest {

    @InjectMocks
    private MyModulusServiceImpl myModulusService;

    @BeforeEach
    void setUp() { myModulusService = new MyModulusServiceImpl(); }

    @Test
    @DisplayName("Service should be properly initialized")
    void testServiceInitialization() {
        assertNotNull(myModulusService, "MyModulus service should not be null");
    }

    @Test
    @DisplayName("Modulus with zero divisor should return NaN")
    void testModulus_ZeroDivisor() {
        double result = myModulusService.modulus(5, 0);
        assertTrue(Double.isNaN(result));
    }

    @Test
    @DisplayName("Modulus should handle edge cases and boundary conditions")
    void testModulus_EdgeCases() {
        Assertions.assertEquals(1.0, myModulusService.modulus(5.0, 2.0), 0.001);

        assertTrue(Double.isNaN(myModulusService.modulus(5.0, 0.0)), "Result should be NaN when divisor is zero");

        Assertions.assertEquals(5.0, myModulusService.modulus(5.0, Double.POSITIVE_INFINITY), 0.001);
    }
}
