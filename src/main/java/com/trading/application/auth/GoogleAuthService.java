package com.trading.application.auth;


import com.trading.application.auth.response.GoogleUserRes;

public interface GoogleAuthService {

    GoogleUserRes requestUserInfo(String idToken);

}
