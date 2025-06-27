
package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
public class UserControllerExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testUserNotFound() throws Exception {
        Mockito.when(userService.getUserById(100L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/users/100"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}
