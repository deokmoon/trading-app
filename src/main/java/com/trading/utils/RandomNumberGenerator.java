package com.trading.utils;

import java.util.Random;

public class RandomNumberGenerator {

    public RandomNumberGenerator() {
        throw new UnsupportedOperationException("RandomNumberGenerator");
    }

    public static String generateSixDigitNumber() {
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
