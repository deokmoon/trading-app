package com.trading.client.ui.request;

import com.trading.common.annotation.Description;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class ResetPasswordReq {

    @Description("이메일")
    @NotBlank
    private String email;

    @Description("인증키")
    @NotBlank
    private String authKey;

    @Description("비밀번호")
    @NotBlank
    private String password;

}
