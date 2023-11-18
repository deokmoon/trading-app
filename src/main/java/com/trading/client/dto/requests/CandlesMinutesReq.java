package com.trading.client.dto.requests;

import com.trading.client.constant.CandlesUnitType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CandlesMinutesReq {

    private String unit;

    private String market;

    private LocalDateTime to;

    private Integer count;

}
