package com.trading.common.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BoardErrorCode implements ErrorCode {
    NO_BOARD("게시물정보가 없습니다.", HttpStatus.NOT_FOUND),
    ;

    private static final String title = "Board";

    String code;

    String message;

    HttpStatus httpStatus;

    BoardErrorCode(String message, HttpStatus status) {
        this(title, message, status);
    }

}

