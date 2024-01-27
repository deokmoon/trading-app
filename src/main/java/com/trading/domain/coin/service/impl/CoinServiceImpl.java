package com.trading.domain.coin.service.impl;

import com.trading.controller.coin.request.CoinListReq;
import com.trading.controller.coin.response.CoinListRes;
import com.trading.controller.coin.response.CoinRes;
import com.trading.domain.coin.service.CoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CoinServiceImpl implements CoinService {

    @Override
    public CoinListRes getCoinList(CoinListReq req) {
        return null;
    }

    @Override
    public CoinRes getCoin(String coinId) {
        return CoinRes.from();
    }

}
