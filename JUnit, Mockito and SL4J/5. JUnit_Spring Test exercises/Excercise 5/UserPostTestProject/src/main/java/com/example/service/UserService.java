
package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User saveUser(User user) {
        // Simulate saving and returning user with id
        user.setId(1L);
        return user;
    }
}
