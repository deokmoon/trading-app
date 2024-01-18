package com.trading.common.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements ErrorCode {
    NO_USER("사용자정보가 없습니다.", HttpStatus.NOT_FOUND),
    ;

    private static final String title = "User";

    String code;

    String message;

    HttpStatus httpStatus;

    UserErrorCode(String message, HttpStatus status) {
        this(title, message, status);
    }

}

