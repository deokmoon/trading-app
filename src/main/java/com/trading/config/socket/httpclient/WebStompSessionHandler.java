package com.trading.config.socket.httpclient;

import com.trading.upbit.market.domain.MarketBaseStorage;
import com.trading.upbit.ticker.dto.UpbitTickerRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import java.lang.reflect.Type;

@Slf4j
public class WebStompSessionHandler implements StompSessionHandler {

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("Connected to the server");
//        log.debug("Connected to the server");
        UpbitTickerRequestDto requestDto = UpbitTickerRequestDto.builder()
                .ticket("test example")
                .type("ticker")
                .codes(MarketBaseStorage.getMarketList())
                .format("DEFAULT")
                .isOnlyRealtime(true)
                .build();
        String requestMessage = requestDto.toString();
        session.send("", requestMessage);
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        System.out.println("Error during processing of a STOMP command, message: " + exception.getMessage());
//        log.error("Error during processing of a STOMP command, message: " + exception.getMessage());
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {System.out.println();
        System.out.println("Transport error, message: " + exception.getMessage());
//        log.error("Transport error, message: " + exception.getMessage());
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override // 서버로부터 메시지 수신 시 처리
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println(payload.toString());
    }
}
