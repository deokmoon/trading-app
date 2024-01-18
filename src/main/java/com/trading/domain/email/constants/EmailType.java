package com.trading.domain.email.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailType {

    SIGNUP("authNewEmail", "드림투두 회원가입을 축하합니다.", "드림투두 회원가입을 축하합니다.\nWelcome to signup 드림투두\n\n아래 코드로 이메일 인증을 해주세요.\nVerify your Email by follow code\n\ncode : "),
    RESET_PASSWORD("resetPassword", "드림투두 비밀번호 초기화 이메일입니다.", "드림투두 비밀번호 초기화 이메일입니다.\n드림투두 Password reset email.\n\n아래 URL 로 비밀번호 초기화를 해주세요.\nReset Password by follow URL\n\nURL : "),
    ;

    @JsonValue
    private String code;

    private String subject;

    private String text;

}
