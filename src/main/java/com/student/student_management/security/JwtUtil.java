package com.student.student_management.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey";

    // ✅ Generate Token
    public String generateToken(String rollNo) {
        return Jwts.builder()
                .setSubject(rollNo)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
                .signWith(SignatureAlgorithm.HS256, SECRET.getBytes()) // ✅ FIX
                .compact();
    }

    // ✅ Extract RollNo
    public String extractRollNo(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ Extract Expiration
    public Date extractExpiration(String token) {
        return getClaims(token).getExpiration();
    }

    // ✅ Check if token expired
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // ✅ Validate Token
    public boolean validateToken(String token) {
        try {
            Claims claims = getClaims(token); // validates signature
            System.out.println("Token Valid. Expiry: " + claims.getExpiration());
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            System.out.println("JWT ERROR: " + e.getClass().getName());
            System.out.println("JWT MESSAGE: " + e.getMessage());
            return false;
        }
    }

    // 🔐 Internal method
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}