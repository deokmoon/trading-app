package com.trading.remote.upbit.market.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "UpbitMarketCodeInquiry"
        , url = "${upbit.api.uri}"
)
public interface MarketCodeInquiry {

    @GetMapping("/market/all")
    ResponseEntity<String> getAllMarketInformation();

}
