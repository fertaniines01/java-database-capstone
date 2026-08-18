package com.project.back_end.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

/**
 * Service responsible for generating and validating JWT tokens.
 */
@Service
public class TokenService {

    // Clé secrète configurée (doit faire au moins 256 bits pour HS256)
    private final String SECRET_KEY = "mySecretKeyForJWTTokenGenerationNeedsToBeLongEnoughForHS256";

    /**
     * Helper method to retrieve the signing key derived from the configured secret.
     * 
     * @return Key used for signing and validating JWTs.
     */
    public Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    /**
     * Generates a JWT token for a given user email with issue and expiration dates.
     * 
     * @param email The user's email address.
     * @return String representation of the JWT token.
     */
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 heures
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Validates the structure and signature of a JWT token.
     * 
     * @param token The token string to validate.
     * @return true if valid, false otherwise.
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
