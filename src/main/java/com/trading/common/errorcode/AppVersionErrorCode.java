package com.trading.common.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AppVersionErrorCode implements ErrorCode {
    NO_APP_VERSION("앱 버전 정보가 없습니다.", HttpStatus.NOT_FOUND),
    ;

    private static final String title = "AppVersion";

    String code;

    String message;

    HttpStatus httpStatus;

    AppVersionErrorCode(String message, HttpStatus status) {
        this(title, message, status);
    }

}


