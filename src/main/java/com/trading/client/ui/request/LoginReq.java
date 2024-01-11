package com.trading.client.ui.request;

import com.trading.common.annotation.Description;
import com.trading.common.constants.YesNo;
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
//    @NonNull
    private String email;

    @Description("패스워드")
//    @NonNull
    private String password;

    @Description("자동로그인 여부")
    private YesNo autoLogin;

}
