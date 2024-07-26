package com.rs.fer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rs.fer.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

    @GetMapping("/home")
    public String home(@RequestHeader("Authorization") String token) {
        String jwt = token;
        if (authService.getJwtUtil().validateToken(jwt)) {
            String username = authService.getJwtUtil().extractUsername(jwt);
            return "Hi " + username;
        } else {
            throw new RuntimeException("Invalid token");
        }
    }
}
