package com.trading.controller.ui.request;

import com.trading.common.annotation.Description;
import com.trading.common.constants.YesNo;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import com.trading.domain.user.dto.UserDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupReq {

    @Description("이메일주소")
    @NotBlank
    private String email;

    @Description("이름")
    @NotBlank
    private String name;

    @Description(value = "패스워드", comment = "SHA256 암호화된 문자열")
    @NotBlank
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
        String userId = UUID.randomUUID().toString();
//        String authKey = AuthUtils.getRandomValue(16);
//        String authKey = AuthUtils.generateEmailCode();

        return User.builder()
                .userId(userId)
                .email(email)
                .name(name)
                .pw(hashedPw)
                .profile(profile)
                .cretId(userId)
                .modId(userId)
//                .authKey(authKey)
                .authYn(YesNo.NO)
                .profilePicUrl(profile)
                .authType(AuthType.EMAIL)
                .build();
    }

}
