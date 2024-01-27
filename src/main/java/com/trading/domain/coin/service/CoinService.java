package com.trading.domain.coin.service;

import com.trading.controller.coin.request.CoinListReq;
import com.trading.controller.coin.response.CoinListRes;
import com.trading.controller.coin.response.CoinRes;

public interface CoinService {

    CoinListRes getCoinList(CoinListReq req);

    CoinRes getCoin(String coinId);

}
