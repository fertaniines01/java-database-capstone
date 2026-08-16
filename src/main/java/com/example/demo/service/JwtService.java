package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY = "SecretKeyForJwtTokenGenerationAndValidationSecretKey";

    public String generateToken(String username, String role) {
        return "mock_jwt_token_" + username + "_" + role;
    }

    public String extractUsername(String token) {
        if (token != null && token.startsWith("mock_jwt_token_")) {
            String[] parts = token.split("_");
            return parts[3];
        }
        return null;
    }

    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername != null && extractedUsername.equals(username));
    }
}
