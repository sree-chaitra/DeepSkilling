
package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public Optional<User> getUserById(Long id) {
        if (id == 1L) {
            return Optional.of(new User(1L, "Sample User"));
        }
        return Optional.empty();
    }
}
