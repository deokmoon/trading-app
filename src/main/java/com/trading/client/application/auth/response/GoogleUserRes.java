package com.trading.client.application.auth.response;

import com.google.api.client.json.webtoken.JsonWebToken;
import com.trading.common.constants.YesNo;
import com.trading.domain.user.User;
import com.trading.domain.user.constants.AuthType;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@Builder
public class GoogleUserRes {

    public String email;

    public Boolean emailVerified;

    public String name;

    public String givenName;

    public String familyName;

    public String picture;

    public String locale;

    public static GoogleUserRes from(JsonWebToken.Payload payload) {
        return GoogleUserRes.builder()
                .email((String) payload.get("email"))
                .emailVerified((Boolean) payload.get("email_verified"))
                .name((String) payload.get("name"))
                .givenName((String) payload.get("given_name"))
                .familyName((String) payload.get("family_name"))
                .picture((String) payload.get("picture"))
                .locale((String) payload.get("locale"))
                .build();
    }

    public boolean isVerified() {
        return (StringUtils.hasText(this.email) && this.emailVerified);
    }

    public User toUser() {
        return User.builder()
                .email(email)
                .name(name)
                .profilePicUrl(picture)
                .authYn(YesNo.YES)
                .authType(AuthType.GOOGLE)
                .build();
    }

}
