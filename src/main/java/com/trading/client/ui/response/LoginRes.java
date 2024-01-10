package com.trading.client.ui.response;

import com.trading.common.constants.YesNo;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;

@Getter
@Builder
public class LoginRes {

    private String refreshTokenKey;

    private String accessToken;

    private UserRes userRes;

    @Getter
    @Builder
    public static class UserRes {

        private String userId;

        private String email;

        private String name;

        private String profile;

        private String profilePicUrl;

        private AuthType authType;

        private YesNo autoLogin;

        public static UserRes of(User user, YesNo autoLogin) {
            return UserRes.builder()
                    .userId(user.getUserId())
                    .email(user.getEmail())
                    .name(user.getName())
                    .profile(user.getProfile())
                    .profilePicUrl(user.getProfilePicUrl())
                    .authType(user.getAuthType())
                    .autoLogin(autoLogin)
                    .build();
        }

        public HashMap<String, Object> toHashMap() {
            final HashMap<String, Object> map = new HashMap();
            map.put("userId", userId);
            map.put("email", email);
            map.put("name", name);
            map.put("profile", profile);
            map.put("profilePicUrl", profilePicUrl);
            map.put("authType", authType);
            map.put("autologin", autoLogin);
            return map;
        }

    }

}
