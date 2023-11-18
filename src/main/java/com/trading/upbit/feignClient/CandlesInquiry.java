package com.trading.upbit.feignClient;

import com.trading.upbit.dto.response.UpbitCandlesMinutesRes;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "UpbitCandlesInquiry"
        , url = "${upbit.api.uri}"
)
public interface CandlesInquiry {
    @GetMapping("/candles/minutes/{unit}?market={market}&to={to}&count={count}")
    List<UpbitCandlesMinutesRes> getCandlesMinutes(@PathVariable("unit") String unit,
                                                   @PathVariable("market")String market,
                                                   @PathVariable("to") String to,
                                                   @PathVariable("count") Integer count);
}
