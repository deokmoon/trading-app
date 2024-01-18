package com.trading.client.ui.request;

import com.trading.client.application.auth.utils.AuthUtils;
import com.trading.common.annotation.Description;
import com.trading.common.constants.YesNo;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import com.trading.domain.user.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupReq {

    @Description("이메일주소")
//    @NonNull
    private String email;

    @Description("이름")
//    @NonNull
    private String name;

    @Description("패스워드")
//    @NonNull
    private String password;

    @Description("프로파일")
    private String profile;

    public UserDto toUserDto(String hashedPw) {
        return UserDto.builder()
                .email(email)
                .name(name)
                .pw(hashedPw)
                .profile(profile)
                .build();
    }

    public User toUser(String hashedPw) {
        String userId = AuthUtils.getRandomValue(16);
//        String authKey = AuthUtils.getRandomValue(16);
        String authKey = AuthUtils.generateEmailCode();

        return User.builder()
                .userId(userId)
                .email(email)
                .name(name)
                .pw(hashedPw)
                .profile(profile)
                .cretId(userId)
                .modId(userId)
                .authKey(authKey)
                .authYn(YesNo.NO)
                .profilePicUrl(profile)
                .authType(AuthType.EMAIL)
                .build();
    }

}
