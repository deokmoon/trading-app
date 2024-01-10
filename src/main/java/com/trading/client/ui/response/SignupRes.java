package com.trading.client.ui.response;

import com.trading.common.constants.YesNo;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import com.trading.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupRes {

    private UserRes userRes;

    @Getter
    @Builder
    public static class UserRes {

        private String userId;

        private String password;

        private String email;

        private String name;

        private String profile;

        private String profilePicUrl;

        private String authKey;

        private YesNo authYn;

        private AuthType authType;

        public static UserRes from(User user) {
            return UserRes.builder()
                    .userId(user.getUserId())
                    .password(user.getPw())
                    .email(user.getEmail())
                    .name(user.getName())
                    .profile(user.getProfile())
                    .profilePicUrl(user.getProfilePicUrl())
                    .authKey(user.getAuthKey())
                    .authYn(user.getAuthYn())
                    .authType(user.getAuthType())
                    .build();
        }

    }

}
