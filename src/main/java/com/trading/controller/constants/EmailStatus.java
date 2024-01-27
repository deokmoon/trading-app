package com.trading.controller.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.trading.common.constants.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailStatus implements BaseEnum {
    AUTH("a", "Trading app account is authorized"),
    NO_AUTH("na", "Trading app account is NOT authorized"),
    NO_EXIST("ne", "Trading app account NOT found"),
    ;

    @JsonValue
    private String code;

    private String message;
}

