package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder encoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        User saved = userService.registerUser(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        User user = userService.findByEmail(request.getEmail());

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getRole(),
                user.getId(),
                user.getEmail()
        );

        AuthResponse response = new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(response);
    }
}
