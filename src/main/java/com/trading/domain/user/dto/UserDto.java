package com.trading.domain.user.dto;

import com.trading.common.constants.BaseEnum;
import com.trading.common.constants.YesNo;
import com.trading.common.utils.CommonUtils;
import com.trading.common.utils.MvcUtils;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userId;

    private String email;

    private String name;

    private String pw;

    private String profile;

    private LocalDateTime cretDtime;

    private String cretId;

    private LocalDateTime modDtime;

    private String modId;

    private String authKey;

    @Builder.Default
    private YesNo authYn = YesNo.NO;

    private String profilePicUrl;

    private AuthType authType;

    public void create() {

    }

    public void authenticateEmail() {
        this.authYn = YesNo.YES;
    }

    public void createAuthKey() {
        this.authKey = CommonUtils.getRandomValue(16);
    }

    public void resetPassword(String hashedPassword) {
        this.pw = hashedPassword;
    }

//    @Getter
//    @AllArgsConstructor
//    public enum AuthType implements BaseEnum {
//        EMAIL("EMAIL", "이메일"),
//        GOOGLE("GOOGLE", "구글 Oauth 인증"),
//        APPLE("APPLE", "애플 Oauth 인증"),
//        ;
//
//        private String code;
//
//        private String desc;
//    }

    public static UserDto of(User user) {
        // TODO org.apache.commons.beanutils.PropertyUtilsBean.copyProperties(Object dest, Object orig)
        return UserDto.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .pw(user.getPw())
                .profile(user.getProfile())
                .cretDtime(user.getCretDtime())
                .cretId(user.getCretId())
                .modDtime(user.getModDtime())
                .modId(user.getModId())
                .authKey(user.getAuthKey())
                .authYn(user.getAuthYn())
                .profilePicUrl(user.getProfilePicUrl())
//                .authType(BaseEnum.getEnum(AuthType.class, user.getAuthType()))
                .build();
    }

    public User toUser() {
        String userId = UUID.randomUUID().toString();
        String authKey = UUID.randomUUID().toString();

        return User.builder()
                .userId(userId)
                .email(email)
                .name(name)
                .pw(pw)
                .profile(profile)
                .cretId(cretId)
                .modId(modId)
                .authKey(authKey)
                .authYn(authYn)
                .profilePicUrl(profilePicUrl)
//                .authType(authType.getCode())
                .build();
    }

    public static UserDto get() {
        HttpServletRequest request = MvcUtils.getHttpServletRequest();
        UserDto userDto = (UserDto) request.getAttribute("user");
        if (Objects.nonNull(userDto)) {
            return userDto;
        }
        return new UserDto();
    }

}
