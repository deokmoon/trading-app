package com.trading.application.auth.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

public final class JwtUtils {

    public JwtUtils() {
        throw new UnsupportedOperationException("JwtUtils");
    }

    /**
     * 토큰 생성하기 jwt encode
     */
    public static String createToken(HashMap<String, Object> claims, Duration expSeconds, String secretKey) {
        String base64SecretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(base64SecretKey.getBytes()), SignatureAlgorithm.HS256)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expSeconds.toMillis()))
                .compact();
    }

    /**
     * 토큰 검증하기 jwt decode
     */
    public static Jws<Claims> parseToken(String token, String secretKey) {
        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8)).getBytes())
                .build()
                .parseClaimsJws(token);

        return claims;
    }

}
