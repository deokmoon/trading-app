package com.trading.controller.ui;

import com.trading.domain.auth.response.FindPasswordAuthRes;
import com.trading.domain.auth.response.ReissueAccessTokenRes;
import com.trading.domain.auth.service.AuthService;
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
import com.trading.controller.ui.response.InitDateRes;
import com.trading.controller.ui.response.LoginRes;
import com.trading.controller.ui.response.LogoutRes;
import com.trading.controller.ui.response.SignupRes;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Value("${spring.mail.username}")
    private String emailUser;

    @Value("${myprofile}")
    private String myprofile;

    private final AuthService authService;

    @GetMapping("/index")
    public String getAuth() {
        return "Auth!" + myprofile;
    }

    /**
     * Appkey 발행하기
     */
    @GetMapping("/appkey")
    public String getAppkey(HttpServletResponse response) {
        Cookie cookie = authService.getAppKey();
        response.addCookie(cookie);
        return "check cookie";
    }

    /**
     * 초기데이터를 조회하기
     */
    @GetMapping("/initdata")
    public InitDateRes getInitData(HttpServletResponse response) {
        Cookie cookie = authService.getAppKey();
        response.addCookie(cookie);
        return new InitDateRes(emailUser);
    }


    /**
     * 이메일주소 중복 체크하기
     */
    @GetMapping("/check-dupl-email")
    public CheckDuplEmailRes checkDuplEmail(@Valid @ModelAttribute CheckDuplEmailReq req) {
        CheckDuplEmailRes checkDuplEmailRes = authService.checkDuplEmail(req);
        return checkDuplEmailRes;
    }

    /**
     * 회원가입하기
     */
    @PostMapping("/signup")
    public SignupRes signup(@Valid @RequestBody SignupReq signupReq) {
        SignupRes signupRes = authService.signup(signupReq);
        return signupRes;
    }

    /**
     * 이메일코드 인증하기
     */
    @PostMapping("/email")
    public EmailAuthRes emailAuth(@Valid @RequestBody EmailAuthReq emailAuthReq) {
        EmailAuthRes emailAuthRes = authService.emailAuth(emailAuthReq);
        return emailAuthRes;
    }

    /**
     * 로그인하기
     */
    @PostMapping("/login")
    public LoginRes login(@Valid @RequestBody LoginReq loginReq) {
        LoginRes loginRes = authService.login(loginReq);
        return loginRes;
    }

    /**
     * 로그아웃하기
     */
    @PostMapping("/logout")
    public LogoutRes logout(@Valid @RequestBody LogoutReq logoutReq) {
        LogoutRes logoutRes = authService.logout(logoutReq);
        return logoutRes;
    }

    /**
     * 비밀번호 초기화 이메일 발송하기
     */
    @PostMapping("/password/find")
    public String findPassword(@RequestBody FindPasswordReq req) {
        authService.findPassword(req);
        return "Email is Sent";
    }

    /**
     * 비밀번호 초기화 코드 검증
     */
    @Deprecated(forRemoval = true)
    @GetMapping("/password/find")
    public FindPasswordAuthRes findPasswordAuth(@Valid @RequestBody FindPasswordAuthReq findPasswordAuthReq) {
        FindPasswordAuthRes findPasswordAuthRes = authService.findPasswordAuth(findPasswordAuthReq);
        return findPasswordAuthRes;
    }

    /**
     * 비밀번호 초기화하기
     */
    @PostMapping("/password/reset")
    public String resetPassword(@RequestBody ResetPasswordReq req) {
        String userId = authService.resetPassword(req);
        return userId;
    }

    /**
     * accessToken 을 재발행한다.
     */
    @PostMapping("/reissue-access-token")
    public ReissueAccessTokenRes reissueAccessToken(@RequestBody ReissueAccessTokenReq req) {
        ReissueAccessTokenRes reissueAccessTokenRes = authService.reissueAccessToken(req);
        return reissueAccessTokenRes;
    }

    /**
     * google idToken 을 검증하고, 로그인처리한다.
     */
    @PostMapping("/google/verify")
    public LoginRes verifyGoogle(@RequestBody GoogleVerifyReq googleVerifyReq) {
        LoginRes loginRes = authService.verifyGoogle(googleVerifyReq);
        return loginRes;
    }

    /**
     * TODO apple 로그인을 인증한다
     */

}
