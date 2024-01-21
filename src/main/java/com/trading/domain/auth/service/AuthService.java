package com.trading.domain.auth.service;

import com.trading.domain.auth.response.FindPasswordAuthRes;
import com.trading.domain.auth.response.ReissueAccessTokenRes;
import com.trading.controller.ui.request.CheckDuplEmailReq;
import com.trading.controller.ui.request.EmailAuthReq;
import com.trading.controller.ui.request.FindPasswordAuthReq;
import com.trading.controller.ui.request.FindPasswordReq;
import com.trading.controller.ui.request.GoogleVerifyReq;
import com.trading.controller.ui.request.LoginReq;
import com.trading.controller.ui.request.LogoutReq;
import com.trading.controller.ui.request.ReissueAccessTokenReq;
import com.trading.controller.ui.request.ResetPasswordReq;
import com.trading.controller.ui.request.SignupReq;
import com.trading.controller.ui.response.CheckDuplEmailRes;
import com.trading.controller.ui.response.EmailAuthRes;
import com.trading.controller.ui.response.LoginRes;
import com.trading.controller.ui.response.LogoutRes;
import com.trading.controller.ui.response.SignupRes;
import jakarta.servlet.http.Cookie;

public interface AuthService {

    Cookie getAppKey();

    CheckDuplEmailRes checkDuplEmail(CheckDuplEmailReq req);

    SignupRes signup(SignupReq signupReq);

    EmailAuthRes emailAuth(EmailAuthReq emailAuthReq);

    LoginRes login(LoginReq loginReq);

    LogoutRes logout(LogoutReq logoutReq);

    void findPassword(FindPasswordReq req);

    FindPasswordAuthRes findPasswordAuth(FindPasswordAuthReq findPasswordAuthReq);

    String resetPassword(ResetPasswordReq req);

    ReissueAccessTokenRes reissueAccessToken(ReissueAccessTokenReq req);

    LoginRes verifyGoogle(GoogleVerifyReq googleVerifyReq);

    // TODO verifyApple
}
