
package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public Optional<User> getUserById(Long id) {
        // Simulate user not found
        return Optional.empty();
    }
}
