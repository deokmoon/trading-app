package com.trading.client.application.auth.service;

import com.trading.client.application.auth.response.FindPasswordAuthRes;
import com.trading.client.application.auth.response.ReissueAccessTokenRes;
import com.trading.client.ui.request.CheckDuplEmailReq;
import com.trading.client.ui.request.EmailAuthReq;
import com.trading.client.ui.request.FindPasswordReq;
import com.trading.client.ui.request.GoogleVerifyReq;
import com.trading.client.ui.request.LoginReq;
import com.trading.client.ui.request.LogoutReq;
import com.trading.client.ui.request.ReissueAccessTokenReq;
import com.trading.client.ui.request.ResetPasswordReq;
import com.trading.client.ui.request.SignupReq;
import com.trading.client.ui.response.CheckDuplEmailRes;
import com.trading.client.ui.response.EmailAuthRes;
import com.trading.client.ui.response.LoginRes;
import com.trading.client.ui.response.LogoutRes;
import com.trading.client.ui.response.SignupRes;
import jakarta.servlet.http.Cookie;

public interface AuthService {

    Cookie getAppKey();

    CheckDuplEmailRes checkDuplEmail(CheckDuplEmailReq req);

    SignupRes signup(SignupReq signupReq);

    EmailAuthRes emailAuth(EmailAuthReq emailAuthReq);

    LoginRes login(LoginReq loginReq);

    LogoutRes logout(LogoutReq logoutReq);

    void findPassword(FindPasswordReq req);

    FindPasswordAuthRes findPasswordAuth(String userId, String authKey);

    String resetPassword(ResetPasswordReq req);

    ReissueAccessTokenRes reissueAccessToken(ReissueAccessTokenReq req);

    LoginRes verifyGoogle(GoogleVerifyReq googleVerifyReq);

    // TODO verifyApple
}
