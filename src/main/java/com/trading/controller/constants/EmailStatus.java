package com.trading.controller.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.trading.common.constants.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailStatus implements BaseEnum {
    AUTH("a", "인증된 이메일"),
    NO_AUTH("na", "미인증된 이메일"),
    NO_EXIST("ne", "없는 이메일"),
    ;

    @JsonValue
    private String code;

    private String desc;
}

