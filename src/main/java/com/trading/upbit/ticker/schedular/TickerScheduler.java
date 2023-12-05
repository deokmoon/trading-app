package com.trading.upbit.ticker.schedular;

import com.trading.config.socket.httpclient.WebsocketClientEndpoint2;
import com.trading.upbit.market.domain.MarketBaseStorage;
import com.trading.upbit.ticker.dto.UpbitTickerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@DependsOn("marketScheduler")
public class TickerScheduler {
//    private final UpbitWebSocketClientEndpoint upbitWebSocketClient;
    private final WebsocketClientEndpoint2 websocketClientEndpoint2;

    @Scheduled(fixedDelayString = "${schedule.fixed.delay.upbit}")
    public void connectSocketAndTickerHandler() {
        UpbitTickerRequestDto requestDto = UpbitTickerRequestDto.builder()
                .ticket("test example")
                .type("ticker")
                .codes(MarketBaseStorage.getMarketList())
                .format("DEFAULT")
                .isOnlyRealtime(true)
                .build();
        String requestMessage = requestDto.toString();
        websocketClientEndpoint2.connect();
    }
}
