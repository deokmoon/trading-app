package com.trading.controller.ui.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CandlesMinutesReq {

    // TODO unit 의 타입을 CandlesUnitType 으로 변경이 필요함. 현재 파싱오류
//    private CandlesUnitType unit;

    @NotBlank
    private String market;

    private LocalDateTime to;

    private Integer count;

}
