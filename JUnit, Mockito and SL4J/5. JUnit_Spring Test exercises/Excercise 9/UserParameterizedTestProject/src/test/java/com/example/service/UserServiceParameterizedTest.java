
package com.example.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceParameterizedTest {

    private final UserService userService = new UserService();

    @ParameterizedTest
    @CsvSource({
            "John, true",
            "'', false",
            "Al, false",
            "Alice, true",
            "'   ', false",
            "Bob, true",
            "null, false"
    })
    void testIsValidUserName(String input, boolean expected) {
        boolean result = userService.isValidUserName("null".equals(input) ? null : input);
        assertEquals(expected, result);
    }
}
