package com.trading.common.utils;

import java.util.Random;
import java.util.UUID;

public final class CommonUtils {

    public CommonUtils() {
        throw new UnsupportedOperationException("CommonUtils Class");
    }

    public static String getRandomValue(Integer length) {
        Random random = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();

    }

    public static String createUUID() {
        return UUID.randomUUID().toString();
    }

}
