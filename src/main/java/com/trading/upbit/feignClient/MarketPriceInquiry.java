package com.trading.upbit.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UpbitMarketPriceInquiry"
        , url = "${upbit.api.uri}"
)
public interface MarketPriceInquiry {

    @GetMapping("/accounts")
    ResponseEntity<String> getMyData();

    @GetMapping("/ticker?markets={markets}")
    ResponseEntity<String> getStockTickerPrice(@PathVariable("markets") String markets);

    @GetMapping("/orderbook?markets={markets}")
    ResponseEntity<String> getStockOrderBook(@PathVariable("markets") String markets);
}
