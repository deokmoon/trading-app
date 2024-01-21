package com.trading.controller.ui.request;

import com.trading.common.annotation.Description;
import com.trading.common.constants.YesNo;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReissueAccessTokenReq {

    private String userId;

    private String refreshTokenKey;

    @Description("자동로그인 여부")
    private YesNo autoLogin;

}
