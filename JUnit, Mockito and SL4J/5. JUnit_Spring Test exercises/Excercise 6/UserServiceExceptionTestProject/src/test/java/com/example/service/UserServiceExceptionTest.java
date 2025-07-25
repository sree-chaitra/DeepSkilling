
package com.example.service;

import com.example.model.User;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceExceptionTest {

    private final UserService userService = new UserService();

    @Test
    public void testGetUserById_UserNotFound() {
        Optional<User> result = userService.getUserById(999L);
        assertThat(result).isEmpty();
    }
}
