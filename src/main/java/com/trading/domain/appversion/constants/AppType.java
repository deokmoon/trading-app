package com.trading.domain.appversion.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.trading.common.constants.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum AppType implements BaseEnum {

    IOS("ios"),
    AOS("aos"),
    ;

    @JsonValue
    private String code;

    public static AppType getByCode(String code) {
        return Arrays.stream(AppType.values())
                .filter(awAirType -> Objects.equals(awAirType.getCode(), code))
                .findFirst()
                .orElseGet(() -> null);
    }

}
