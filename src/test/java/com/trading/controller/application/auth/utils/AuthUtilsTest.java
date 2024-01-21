package com.trading.controller.application.auth.utils;

import com.trading.utils.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AuthUtilsTest {

    @Test
    public void testGeneratedNumber() {
        for (int i = 0; i < 1000; i++) {
            String generatedNumber = RandomNumberGenerator.generateSixDigitNumber();
            // Check the length
            assertTrue(generatedNumber.length() == 6);

            // Check the first digit
            assertTrue(generatedNumber.charAt(0) != '0');

            // Check for consecutive zeros
            boolean consecutiveZeros = false;
            for (int j = 0; j < 4; j++) {
                if (generatedNumber.charAt(j) == '0' && generatedNumber.charAt(j + 1) == '0') {
                    consecutiveZeros = true;
                    break;
                }
            }
            assertTrue(!consecutiveZeros);
        }
    }

}
