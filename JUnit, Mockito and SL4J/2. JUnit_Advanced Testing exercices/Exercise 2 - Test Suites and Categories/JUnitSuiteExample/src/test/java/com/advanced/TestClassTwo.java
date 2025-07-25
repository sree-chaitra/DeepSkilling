package com.advanced;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestClassTwo {

    @Test
    void testTwo() {
        System.out.println("Test Two Executed");
        assertEquals(10, 5 + 5);
    }
}
