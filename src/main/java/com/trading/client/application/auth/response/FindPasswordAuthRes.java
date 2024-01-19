package com.trading.client.application.auth.response;

import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindPasswordAuthRes {

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

    }

    public static FindPasswordAuthRes from(User user) {
        return FindPasswordAuthRes.builder()
                .userRes(UserRes.builder()
                        .userId(user.getUserId())
                        .email(user.getEmail())
                        .name(user.getName())
                        .profile(user.getProfile())
                        .profilePicUrl(user.getProfilePicUrl())
                        .authType(user.getAuthType())
                        .build())
                .build();
    }

}
