package com.trading.common.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AppKeyFilterErrorCode implements ErrorCode {

    NO_APPKEY("appkey must be included or is wrong", HttpStatus.UNAUTHORIZED);

    private static final String title = "AppKeyFilter";

    String code;

    String message;

    HttpStatus httpStatus;

    AppKeyFilterErrorCode(String message) {
        this(title, message, HttpStatus.BAD_REQUEST);
    }

    AppKeyFilterErrorCode(String message, HttpStatus status) {
        this(title, message, status);
    }

}
