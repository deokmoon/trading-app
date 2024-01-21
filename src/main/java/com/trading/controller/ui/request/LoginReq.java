package com.trading.controller.ui.request;

import com.trading.common.annotation.Description;
import com.trading.common.constants.YesNo;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {

    @Description("이메일주소")
    @NotBlank
    private String email;

    @Description(value = "패스워드", comment = "SHA256 암호화된 문자열")
    @NotBlank
    private String password;

    @Description("자동로그인 여부")
    private YesNo autoLogin;

}
