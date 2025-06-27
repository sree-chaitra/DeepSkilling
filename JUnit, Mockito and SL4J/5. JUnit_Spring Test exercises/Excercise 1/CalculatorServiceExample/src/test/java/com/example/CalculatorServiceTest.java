package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        // Step 1: Create object of CalculatorService
        CalculatorService calculatorService = new CalculatorService();

        // Step 2: Call add method and check result
        int result = calculatorService.add(5, 3);

        // Step 3: Validate result
        assertEquals(8, result);
    }
}
