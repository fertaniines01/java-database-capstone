package com.project.back_end.services;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TokenService {

    public String generateToken(String username) {
        return UUID.randomUUID().toString() + "-" + username;
    }

    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }
}
