package com.trading.util;

public class TradingAppStringUtils {
    public static String[] splitAndTrim(String str) {
        String[] stringArray = str.split(",");

        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = stringArray[i].trim();
        }

        return stringArray;
    }
}
