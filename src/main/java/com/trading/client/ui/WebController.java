package com.trading.client.ui;

import com.trading.client.application.UpbitService;
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

    @GetMapping("/get/ticker/{markets}")
    public ResponseEntity<List<InquiryPriceTickerDto>> getUpbitTickerPrice(@PathVariable() String markets) {
        return ResponseEntity.ok(upbitService.getUpbitTickerPrice(markets));
    }

    @GetMapping("/get/order-book/{markets}")
    public ResponseEntity<List<InquiryPriceOrderBookDto>> getOrderBookPrice(@PathVariable() String markets) {
        return ResponseEntity.ok(upbitService.getOrderBookPrice(markets));
    }
}
