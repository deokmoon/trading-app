package com.trading.controller.ui.request;

import com.trading.common.annotation.Description;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;

@Getter
public class ResetPasswordReq {

    @Description("사용자ID")
    @NotBlank
    private String userId;

    @Description("인증키")
    @NotBlank
    private String authKey;

    @Description("비밀번호")
    @NotBlank
    private String password;

}
