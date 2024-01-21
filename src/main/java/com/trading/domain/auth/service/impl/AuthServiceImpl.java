package com.trading.domain.auth.service.impl;

import com.trading.domain.auth.constants.Token;
import com.trading.domain.auth.response.FindPasswordAuthRes;
import com.trading.domain.auth.response.GoogleUserRes;
import com.trading.domain.auth.response.ReissueAccessTokenRes;
import com.trading.domain.auth.response.TokenRes;
import com.trading.domain.auth.service.AuthService;
import com.trading.domain.auth.service.GoogleAuthService;
import com.trading.domain.auth.utils.JwtUtils;
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
import com.trading.common.constants.YesNo;
import com.trading.common.errorcode.AuthErrorCode;
import com.trading.common.exception.TradRuntimeException;
import com.trading.common.utils.CommonUtils;
import com.trading.domain.email.constants.EmailType;
import com.trading.domain.email.dto.EmailDto;
import com.trading.domain.email.service.EmailService;
import com.trading.domain.redis.service.RedisService;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import com.trading.domain.user.service.UserService;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    private final EmailService emailService;

    private final RedisService redisService;

    private final GoogleAuthService googleAuthService;

    private final PasswordEncoder passwordEncoder;

    @Value("${app-key}")
    private String appKey;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${host}")
    private String host;

//    private final GoogleOAuthApiClient googleOAuthApiClient;

    /**
     * Appkey 발행하기
     */
    @Override
    public Cookie getAppKey() {
        Cookie cookie = new Cookie("x_appkey", appKey);
        cookie.setMaxAge(60 * 60 * 24 * 1); // 1일간
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }

    /**
     * 이메일주소 중복 체크하기
     */
    @Override
    public CheckDuplEmailRes checkDuplEmail(CheckDuplEmailReq req) {
        // 기존에 있는 이메일인지 확인한다.
        Optional<User> maybeUser = userService.findByEmailAndAuthType(req.getEmail(), AuthType.EMAIL);
        maybeUser.ifPresent(user -> {
            // 기존에 이메일이 있으면 -> 409
            throw new TradRuntimeException(AuthErrorCode.DUPLICATED_EMAIL);
        });
        return new CheckDuplEmailRes(req.getEmail());
    }

    /**
     * 회원가입하기
     */
    @Transactional
    @Override
    public SignupRes signup(SignupReq signupReq) {
        // 기존에 있는 이메일인지 확인한다.
        Optional<User> maybeUser = userService.findByEmailAndAuthType(signupReq.getEmail(), AuthType.EMAIL);

        if (maybeUser.isPresent()) {
            // 이메일이 있으면 -> 409
            throw new TradRuntimeException(AuthErrorCode.DUPLICATED_EMAIL);
        }

        // 없으면 -> 계정을 생성
        String hashedPw = passwordEncoder.encode(signupReq.getPassword());
        User user = userService.createUser(signupReq.toUser(hashedPw));
        user.createAuthKey();

        // 회원가입 인증 이메일 발송
        emailService.sendEmail(EmailDto.of(EmailType.SIGNUP, user));

        return SignupRes.builder()
                .userRes(SignupRes.UserRes.from(user))
                .build();
    }

    /**
     * 이메일 인증하기
     */
    @Transactional
    @Override
    public EmailAuthRes emailAuth(EmailAuthReq emailAuthReq) {
        // 사용자정보 조회하기
        User user = userService.findByEmailAndAuthKey(emailAuthReq.getEmail(), emailAuthReq.getCode());

        if (Objects.isNull(user)) {
            // 일치하는 사용자정보가 없으면 -> 401
            throw new TradRuntimeException(AuthErrorCode.FAIL_EMAIL_AUTH);
        }

        // 이메일인증처리
        user.authenticateEmail();
        return EmailAuthRes.from(user);
    }

    /**
     * 로그인하기
     */
    @Override
    public LoginRes login(LoginReq loginReq) {
        // 이메일로 회원정보를 조회한다.
        Optional<User> maybeUser = userService.findByEmailAndAuthType(loginReq.getEmail(), AuthType.EMAIL);
        if (maybeUser.isPresent() == false) {
            throw new TradRuntimeException(AuthErrorCode.FAIL_LOGIN);
        }
        User user = maybeUser.get();
        // 입력받은 비밀번호와 조회한 회원정보의 비밀번호를 비교한다.
        boolean pwMatch = passwordEncoder.matches(loginReq.getPassword(), user.getPw());

        if (Objects.isNull(user) || user.getAuthYn() != YesNo.YES || pwMatch == false) {
            // 해당하는 계정이 없음 || 이메일이 인증된 상태가 아님 || 비밀번호가 일치하지 않음 -> 401 에러
            throw new TradRuntimeException(AuthErrorCode.FAIL_LOGIN);
        }
        LoginRes.UserRes userRes = LoginRes.UserRes.of(user, loginReq.getAutoLogin());

        // 토큰을 생성한다.
        TokenRes tokenRes = issueNewToken(userRes);
        // 일치하면 로그인 정보 리턴
        return LoginRes.builder()
                .accessToken(tokenRes.getAccessToken())
                .refreshTokenKey(tokenRes.getRefreshTokenKey())
                .userRes(userRes)
                .build();
    }

    /**
     * 로그아웃하기
     */
    @Override
    public LogoutRes logout(LogoutReq logoutReq) {
        Boolean isSuccess = redisService.delValue(logoutReq.getRefreshTokenKey());
        return new LogoutRes(isSuccess.toString());
    }

    /**
     * 비밀번호 초기화 이메일 발송하기
     */
    @Transactional
    @Override
    public void findPassword(FindPasswordReq req) {
        // 사용자정보 조회하기
        Optional<User> maybeUser = userService.findByEmailAndAuthType(req.getEmail(), AuthType.EMAIL);
        if (maybeUser.isPresent() == false) {
            // 일치하는 사용자정보가 없으면 -> 404
            throw new TradRuntimeException(AuthErrorCode.NO_EMAIL);
        } else {
            // 무작위 authKey 생성해서 사용자정보에 저장
            User user = maybeUser.get();
            user.createAuthKey();

            // 비밀번호 재설정 이메일 발송
            emailService.sendEmail(EmailDto.of(EmailType.RESET_PASSWORD, user));
        }
    }

    /**
     * 비밀번호 초기화 코드 검증
     */
    @Override
    @Deprecated(forRemoval = true)
    public FindPasswordAuthRes findPasswordAuth(FindPasswordAuthReq findPasswordAuthReq) {
        // 사용자정보 조회하기
        User user = userService.findByEmailAndAuthKey(findPasswordAuthReq.getEmail(), findPasswordAuthReq.getCode());
        if (Objects.isNull(user)) {
            // 일치하는 사용자정보가 없으면 -> 404
            throw new TradRuntimeException(AuthErrorCode.NO_EMAIL);
        }
        return FindPasswordAuthRes.from(user);
    }

    /**
     * 비밀번호 초기화하기
     */
    @Transactional
    @Override
    public String resetPassword(ResetPasswordReq req) {
        // 사용자정보 조회하기
        User user = userService.getUserByUserIdAndAuthKey(req.getUserId(), req.getAuthKey());
        if (Objects.isNull(user)) {
            // 일치하는 사용자정보가 없으면 -> 404
            throw new TradRuntimeException(AuthErrorCode.NO_EMAIL);
        }
        // 비밀번호 재생성
        user.resetPassword(passwordEncoder.encode(req.getPassword()));
        // 이메일인증여부에 Y
        user.authenticateEmail();
        return user.getUserId();
    }

    /**
     * accessToken 을 재발행한다.
     */
    @Transactional
    @Override
    public ReissueAccessTokenRes reissueAccessToken(ReissueAccessTokenReq req) {
        // 회원정보 확인하기
        User user = userService.getUserByUserId(req.getUserId());
        TokenRes tokenRes = issueAccessTokenByRefreshToken(user, req.getAutoLogin(), req.getRefreshTokenKey());
        return ReissueAccessTokenRes.from(tokenRes.getAccessToken());
    }

    /**
     * google 로그인을 인증한다
     */
    @Override
    public LoginRes verifyGoogle(GoogleVerifyReq googleVerifyReq) {
        // idToken 으로 구글 사용자 정보 조회하기
        GoogleUserRes googleUserRes = googleAuthService.requestUserInfo(googleVerifyReq.getIdToken());
        if (googleUserRes.isVerified() == false) {
            throw new TradRuntimeException(AuthErrorCode.FAIL_EMAIL_AUTH);
        }

        // 사용자정보를 가져오거나 생성한다
        User user = userService.getOrCreateUser(googleUserRes, AuthType.GOOGLE);

        LoginRes.UserRes userRes = LoginRes.UserRes.of(user, YesNo.YES);

        // 토큰을 생성한다
        TokenRes tokenRes = issueNewToken(userRes);

        // 일치하면 로그인 정보 리턴
        return LoginRes.builder()
                .accessToken(tokenRes.getAccessToken())
                .refreshTokenKey(tokenRes.getRefreshTokenKey())
                .userRes(userRes)
                .build();
    }

    /**
     * apple 로그인을 인증한다
     */
    // TODO verifyApple


    /**
     * 신규 AccessToken, RefreshToken 생성하기
     */
    private TokenRes issueNewToken(LoginRes.UserRes userRes) {
        HashMap<String, Object> tokenHashMap = userRes.toHashMap();

        // ATK 생성
        tokenHashMap.put("type", Token.ACCESS.toString());
        String atk = JwtUtils.createToken(tokenHashMap, Token.getSeconds(Token.ACCESS), secretKey);

        // RTK 생성
        tokenHashMap.put("type", Token.REFRESH.toString());
        String rtk = JwtUtils.createToken(tokenHashMap, Token.getSeconds(Token.REFRESH), secretKey);

        // RTK 를 REDIS 에 저장
        String rtkKey = CommonUtils.createUUID();
        redisService.setValue(rtkKey, rtk, Token.getSeconds(Token.REFRESH));

        // 리턴
        return TokenRes.builder()
                .accessToken(atk)
                .refreshTokenKey(rtkKey)
                .build();
    }

    /**
     * AccessToken 재발행하기
     */
    private TokenRes issueAccessTokenByRefreshToken(User user, YesNo autoLogin, String refreshTokenKey) {
        Optional<String> maybeRefreshToken = redisService.getValue(refreshTokenKey);
        if (maybeRefreshToken.isPresent()) {
            // ATK 재발행
            HashMap<String, Object> tokenHashMap = user.toHashMap();
            tokenHashMap.put("autologin", autoLogin.getCode());
            tokenHashMap.put("type", Token.ACCESS.toString());
            String atk = JwtUtils.createToken(tokenHashMap, Token.getSeconds(Token.ACCESS), secretKey);

            // 리턴
            return TokenRes.builder()
                    .accessToken(atk)
                    .refreshTokenKey(refreshTokenKey)
                    .build();
        } else {
            // refreshToken 이 없으면 -> 404
            throw new TradRuntimeException(AuthErrorCode.No_REFRESH_TOKEN);
        }
    }

}
