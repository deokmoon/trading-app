package com.trading.domain.email.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailType {

    SIGNUP("authNewEmail", "TradingApp 회원가입을 축하합니다.", "TradingApp 회원가입을 축하합니다.\nWelcome to signup TradingApp\n\n앱에서 아래 코드로 이메일 인증을 해주세요.\nVerify your Email by follow code\n\ncode : "),
    RESET_PASSWORD("resetPassword", "TradingApp 비밀번호 초기화 이메일입니다.", "TradingApp 비밀번호 초기화 이메일입니다.\nTradingApp Password reset email.\n\n앱에서 아래 코드로 이메일 인증을 해주세요.\nVerify your Email by follow code\n\ncode : "),
    ;

    @JsonValue
    private String code;

    private String subject;

    private String text;

}
