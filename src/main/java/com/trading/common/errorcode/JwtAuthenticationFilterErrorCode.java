package com.trading.common.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum JwtAuthenticationFilterErrorCode implements ErrorCode {

    INVALID("access token must be included", HttpStatus.UNAUTHORIZED),
    USER_NOT_FOUND("User is not found", HttpStatus.UNAUTHORIZED),
    REISSUE("Reissue access token", HttpStatus.FORBIDDEN),
    ;

    private static final String title = "JwtAuthenticationFilter";

    String code;

    String message;

    HttpStatus httpStatus;

    JwtAuthenticationFilterErrorCode(String message, HttpStatus status) {
        this(title, message, status);
    }
}
