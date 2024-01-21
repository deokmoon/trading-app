package com.trading.domain.auth.service;


import com.trading.domain.auth.response.GoogleUserRes;

public interface GoogleAuthService {

    GoogleUserRes requestUserInfo(String idToken);

}
