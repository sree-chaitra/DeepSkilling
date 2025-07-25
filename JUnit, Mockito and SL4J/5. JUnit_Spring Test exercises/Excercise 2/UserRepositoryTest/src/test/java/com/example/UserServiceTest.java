package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class UserServiceTest {

    @Test
    public void testGetUserById() {
        // Step 1: Create mock repository
        UserRepository mockRepository = mock(UserRepository.class);

        // Step 2: Stub the findById method
        User mockUser = new User(1L, "John Doe");
        when(mockRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        // Step 3: Create service
        UserService userService = new UserService(mockRepository);

        // Step 4: Call service method and verify
        User result = userService.getUserById(1L);
        assertNotNull(result);
        assertEquals("John Doe", result.getName());

        // Optional: Verify repository method was called
        verify(mockRepository).findById(1L);
    }
}
