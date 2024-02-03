package com.trading.controller.request;

import com.trading.application.auth.response.GoogleOAuthTokenRes;
import lombok.Getter;

@Getter
public class GoogleVerifyReq {

    private String idToken;

    public GoogleOAuthTokenRes toGoogleOAuthTokenRes() {
        return null;
    }

}
