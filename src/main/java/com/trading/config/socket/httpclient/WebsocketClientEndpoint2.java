package com.trading.config.socket.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

@Slf4j
@Component
public class WebsocketClientEndpoint2 {
    private final WebSocketStompClient stompClient;
    private final String upbitUri = "wss://api.upbit.com/websocket/v1";

    public WebsocketClientEndpoint2() {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        this.stompClient = new WebSocketStompClient(webSocketClient);
        this.stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    }

    public void connect() {
        String url = upbitUri; // WebSocket 서버 주소
        StompSessionHandler sessionHandler = new WebStompSessionHandler(); // 세션 핸들러
        System.out.println("connect");
        // 연결
        stompClient.connect(url, sessionHandler);

        // 필요한 경우에 메시지 전송 등의 작업 수행
//        stompSession.send("/app/hello", "Hello, Server!");
    }
}
