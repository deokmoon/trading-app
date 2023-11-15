package com.trading.client.ui;

import com.trading.client.application.UpbitService;
import com.trading.client.dto.InquiryAllMarketInformationResponseDto;
import com.trading.upbit.dto.InquiryPriceOrderBookDto;
import com.trading.upbit.dto.InquiryPriceTickerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class WebController {

    private final UpbitService upbitService;

    // index
    @GetMapping("/")
    public String index() {
        return "This is trading-app root";
    }

    // 종목코드 조회
    @GetMapping("/market-list")
    public ResponseEntity<List<InquiryAllMarketInformationResponseDto>> getMarketInformationList() {
        return ResponseEntity.ok(upbitService.getMarketInformationList());
    }

    // TODO ui response dto refactoring
    // 현재가 조회
    @GetMapping("/ticker/{markets}")
    public ResponseEntity<List<InquiryPriceTickerDto>> getUpbitTickerPrice(@PathVariable() String markets) {
        return ResponseEntity.ok(upbitService.getUpbitTickerPrice(markets));
    }

    // TODO ui response dto refactoring
    // 호가 조회
    @GetMapping("/order-book/{markets}")
    public ResponseEntity<List<InquiryPriceOrderBookDto>> getOrderBookPrice(@PathVariable() String markets) {
        return ResponseEntity.ok(upbitService.getOrderBookPrice(markets));
    }
}
