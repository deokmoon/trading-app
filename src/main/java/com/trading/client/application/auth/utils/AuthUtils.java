package com.trading.client.application.auth.utils;

import java.security.SecureRandom;
import java.util.stream.Collectors;

public class AuthUtils {

    private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public AuthUtils() {
        throw new UnsupportedOperationException("JwtUtils Class");
    }

    public static String getRandomValue(int length) {
        return SECURE_RANDOM.ints(length, 0, CHARACTERS.length())
                .mapToObj(CHARACTERS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
