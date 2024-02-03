package com.trading.controller.coin;

import com.trading.controller.coin.request.CoinListReq;
import com.trading.controller.coin.response.CoinListRes;
import com.trading.controller.coin.response.CoinRes;
import com.trading.domain.coin.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coin")
public class CoinController {

    private final CoinService coinService;

    @GetMapping
    public CoinListRes getBoardList(CoinListReq req) {
        return coinService.getCoinList(req);
    }

    @GetMapping("/{coinId}")
    public CoinRes getBoard(@PathVariable String coinId) {
        return coinService.getCoin(coinId);
    }

}
