package com.trading.config.socket;

import com.trading.upbit.ticker.event.UpbitTickerEventPublisher;
import jakarta.websocket.OnMessage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

//@ClientEndpoint
public class UpbitWebSocketClientEndpoint extends WebsocketClientEndpoint {
    private UpbitTickerEventPublisher upbitTickerEventPublisher;

    public UpbitWebSocketClientEndpoint() {}

    @Override
    @OnMessage
    public void onMessage(ByteBuffer bytes) throws UnsupportedEncodingException {
        byte[] byteArray = bytes.array();
        int length = bytes.remaining();
        String response = new String(byteArray, bytes.position(), length, "UTF-8");
        upbitTickerEventPublisher.publish(response);
    }

    @Autowired
    public void setUpbitTicketEventPublisher(UpbitTickerEventPublisher upbitTickerEventPublisher) {
        this.upbitTickerEventPublisher = upbitTickerEventPublisher;
    }
}
