package com.execution;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(2)
    void testSecond() {
        System.out.println("This is the second test.");
    }

    @Test
    @Order(1)
    void testFirst() {
        System.out.println("This is the first test.");
    }

    @Test
    @Order(3)
    void testThird() {
        System.out.println("This is the third test.");
    }
}
