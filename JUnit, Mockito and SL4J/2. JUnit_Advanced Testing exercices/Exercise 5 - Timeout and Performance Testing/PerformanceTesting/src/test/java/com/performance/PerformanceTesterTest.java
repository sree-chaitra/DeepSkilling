package com.performance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class PerformanceTesterTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)  // Test must complete within 500 ms
    void testTaskPerformance() {
        PerformanceTester tester = new PerformanceTester();
        tester.performTask();
    }
}
