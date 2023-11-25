package com.trading.client.ui;

import com.trading.client.application.UpbitService;
import com.trading.client.dto.requests.CandlesMinutesReq;
import com.trading.client.dto.response.CandlesMinutesRes;
import com.trading.remote.upbit.ticker.dto.InquiryPriceOrderBookDto;
import com.trading.remote.upbit.ticker.dto.UpbitTickerResponseDto;
import com.trading.util.TradingAppStringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.trading.constant.FileWriteConstants.JSON_FORMAT;
import static com.trading.constant.FileWriteConstants.JSON_RESPONSE_DIRECTORY;
import static com.trading.constant.FileWriteConstants.UPBIT_MARKET_MASTER_FILE_NAME;

@RequiredArgsConstructor
@RestController
public class WebController {

    private final UpbitService upbitService;

    // index
    @GetMapping("/")
    public String index() {
        return "hello-001";
    }

    // 종목코드 조회
    @GetMapping("/market-list")
    public ResponseEntity<byte[]> getMarketInformationList() throws IOException {
        String filePath = JSON_RESPONSE_DIRECTORY + UPBIT_MARKET_MASTER_FILE_NAME + JSON_FORMAT;

        Path path = Paths.get(filePath);
        byte[] fileContent = Files.readAllBytes(path);

        String fileName = UPBIT_MARKET_MASTER_FILE_NAME + JSON_FORMAT;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setContentDispositionFormData(fileName, fileName);

        return ResponseEntity.ok().headers(headers).body(fileContent);
    }

    // todo ui response dto refactoring
    @GetMapping("/ticker")
    public ResponseEntity<List<UpbitTickerResponseDto>> getUpbitTickerPrice(@RequestParam("markets") String markets) {
        return ResponseEntity.ok(upbitService.getUpbitTickerPrice(TradingAppStringUtils.splitAndTrim(markets)));
    }

    // todo ui response dto refactoring
    @GetMapping("/order-book/{markets}")
    public ResponseEntity<List<InquiryPriceOrderBookDto>> getOrderBookPrice(@PathVariable() String markets) {
        return ResponseEntity.ok(upbitService.getOrderBookPrice(markets));
    }

    @GetMapping("/candles/minutes/{unit}")
    public CandlesMinutesRes getCandlesMinutes(@ModelAttribute CandlesMinutesReq req) {
        return upbitService.getCandlesMinutes(req);
    }
}
