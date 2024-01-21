package com.trading.controller.ui.request;

import com.trading.domain.auth.response.GoogleOAuthTokenRes;
import lombok.Getter;

@Getter
public class GoogleVerifyReq {

    private String idToken;

    public GoogleOAuthTokenRes toGoogleOAuthTokenRes() {
        return null;
    }

}
