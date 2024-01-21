package com.trading.domain.upbit.ticker.application;

import com.trading.domain.upbit.ticker.domain.UpbitTicker;
import com.trading.domain.upbit.ticker.domain.UpbitTickerStorage;
import org.springframework.stereotype.Service;

@Service
public class UpbitTickerSocketService {

    public void saveTicker(UpbitTicker upbitTicker) {
        UpbitTickerStorage.save(upbitTicker.getCode(), upbitTicker);
    }
}
