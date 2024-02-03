package com.trading.domain.user.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthType {

    EMAIL("email", "이메일"),
    GOOGLE("goole", "구글"),
    APPLE("apple", "애플"),
    ;

    private final String code;

    private final String desc;

}
