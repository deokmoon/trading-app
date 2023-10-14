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

    @GetMapping("/")
    public String index() {
        return "hello-001";
    }

    @GetMapping("/market-list")
    public ResponseEntity<List<InquiryAllMarketInformationResponseDto>> getMarketInformationList() {
        return ResponseEntity.ok(upbitService.getMarketInformationList());
    }

    // todo ui response dto refactoring
    @GetMapping("/ticker/{markets}")
    public ResponseEntity<List<InquiryPriceTickerDto>> getUpbitTickerPrice(@PathVariable() String markets) {
        return ResponseEntity.ok(upbitService.getUpbitTickerPrice(markets));
    }

    // todo ui response dto refactoring
    @GetMapping("/order-book/{markets}")
    public ResponseEntity<List<InquiryPriceOrderBookDto>> getOrderBookPrice(@PathVariable() String markets) {
        return ResponseEntity.ok(upbitService.getOrderBookPrice(markets));
    }
}
