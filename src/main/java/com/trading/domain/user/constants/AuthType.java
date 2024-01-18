package com.trading.domain.user.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthType {

    EMAIL("EMAIL", "이메일"),
    GOOGLE("GOOGLE", "구글"),
    APPLE("APPLE", "애플"),
    ;

    private final String code;

    private final String desc;

}
