package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/user")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @GetMapping("/")
    public String home() {
        return "<a href=\"/oauth2/authorization/google\">Login with Google</a>";
    }
}
