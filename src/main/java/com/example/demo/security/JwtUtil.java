package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // These fields are set using ReflectionTestUtils in tests
    private String secret;
    private long jwtExpirationMs;

    /**
     * Generate JWT token with required claims
     */
    public String generateToken(
            String username,
            String role,
            Long userId,
            String email) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("userId", userId);
        claims.put("email", email);

        return Jwts.builder()
                .setSubject(username)
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + jwtExpirationMs)
                )
                .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                .compact();
    }

    /**
     * Validate token and return claims
     */
    public Jws<Claims> validateAndGetClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret.getBytes())
                .parseClaimsJws(token);
    }
}
