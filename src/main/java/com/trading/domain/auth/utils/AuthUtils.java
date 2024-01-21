package com.trading.domain.auth.utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Collectors;

public class AuthUtils {

    private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public AuthUtils() {
        throw new UnsupportedOperationException("AuthUtils");
    }

    public static String getRandomValue(int length) {
        return SECURE_RANDOM.ints(length, 0, CHARACTERS.length())
                .mapToObj(CHARACTERS::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    /**
     * 이메일 인증코드 생성하기
     * <p>0 으로 시작하지 않고, 0 이 두 개이상 연속되지 않은 6자리 숫자
     */
    public static String generateEmailCode() {
        Random random = new Random();
        StringBuilder numberBuilder = new StringBuilder();

        // Generate the first digit (1-9)
        numberBuilder.append(random.nextInt(9) + 1);

        // Generate the next five digits
        for (int i = 1; i < 6; i++) {
            int digit = random.nextInt(10);

            // Check if adding the current digit violates the consecutive zero rule
            while (digit == 0 && numberBuilder.charAt(i - 1) == '0') {
                digit = random.nextInt(10);
            }

            numberBuilder.append(digit);
        }

        return numberBuilder.toString();
    }
}
