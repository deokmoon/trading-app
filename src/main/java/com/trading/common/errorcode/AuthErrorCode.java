package com.trading.common.errorcode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum AuthErrorCode implements ErrorCode {

    FAIL_LOGIN("로그인에 실패하였습니다. 이메일, 비밀번호 확인이 필요합니다.", HttpStatus.UNAUTHORIZED),
    DUPLICATED_EMAIL("이미 존재하는 이메일입니다.", HttpStatus.CONFLICT),
    FAIL_EMAIL_AUTH("이메일 인증에 실패했습니다.", HttpStatus.UNAUTHORIZED),
    NO_EMAIL("이메일정보가 없습니다.", HttpStatus.NOT_FOUND),
    No_REFRESH_TOKEN("Refresh Token 이 없습니다.", HttpStatus.NOT_FOUND),
    ;

    private static final String title = "Auth";

    String code;

    String message;

    HttpStatus httpStatus;

    AuthErrorCode(String message, HttpStatus status) {
        this(title, message, status);
    }

}
