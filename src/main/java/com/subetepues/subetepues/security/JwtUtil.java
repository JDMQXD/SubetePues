package com.subetepues.subetepues.security;

import io.jsonwebtoken.*;

import java.security.Key;
import java.util.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "clave_super_secreta_para_jwt_1234567890";
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generarToken(String username, String role) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims obtenerClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validarToken(String token) {
        try {
            obtenerClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String obtenerUsername(String token) {
        return obtenerClaims(token).getSubject();
    }

    public String obtenerRole(String token) {
        return (String) obtenerClaims(token).get("role");
    }
}
