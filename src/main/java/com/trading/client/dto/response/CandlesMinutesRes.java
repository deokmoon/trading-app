package com.trading.client.dto.response;

import com.trading.remote.upbit.dto.response.UpbitCandlesMinutesRes;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CandlesMinutesRes {

    List<UpbitCandlesMinutesRes> list;

    public static CandlesMinutesRes from(List<UpbitCandlesMinutesRes> upbitCandlesMinutesRes) {
        return CandlesMinutesRes.builder()
                .list(upbitCandlesMinutesRes)
                .build();
    }

}
