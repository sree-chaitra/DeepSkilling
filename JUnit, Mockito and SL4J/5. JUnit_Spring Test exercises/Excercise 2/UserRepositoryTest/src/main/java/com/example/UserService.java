package com.example;

public class UserService {
    private UserRepository userRepository;

    // Constructor-based injection (for easy testing)
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
