package com.trading.controller.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.trading.common.constants.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 분 단위. 가능한 값 1, 3, 5, 15, 10, 30, 60, 240
 */
@Getter
@AllArgsConstructor
public enum CandlesUnitType implements BaseEnum {
    ONE("1", "1분"),
    THREE("3", "3분"),
    FIVE("5", "5분"),
    ;

    @JsonValue
    private String code;

    private String desc;
}
