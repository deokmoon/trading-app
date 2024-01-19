package com.trading.client.application.auth.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
public enum Token {
    ACCESS("8h", "8시간"),
    REFRESH("90d", "90일"),
    ;

    private final String exp;
    private final String desc;

    public static Duration getSeconds(Token token) {
        Pattern pattern = Pattern.compile("(\\d+)([hd])\\w*");
        Matcher matcher = pattern.matcher(token.getExp());

        if (matcher.matches()) {
            int value = Integer.parseInt(matcher.group(1));
            String unit = matcher.group(2);
            if (unit.equals("h")) {
                return Duration.ofSeconds(TimeUnit.HOURS.toSeconds(value));
            } else if (unit.equals("d")) {
                return Duration.ofSeconds(TimeUnit.DAYS.toSeconds(value));
            }
        }

        throw new IllegalArgumentException("Invalid time format.");
    }

}
