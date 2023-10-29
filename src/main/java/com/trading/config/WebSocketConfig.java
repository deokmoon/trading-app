package com.trading.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class WebSocketConfig {

    private final String upbitURL = "wss://api.upbit.com/websocket/v1";

    @Bean
    public WebsocketClientEndpoint upbitWebSocketClient() {
        WebsocketClientEndpoint endpoint = new WebsocketClientEndpoint();
        URI upbitWebSocketURI = URI.create(upbitURL);
        endpoint.connect(upbitWebSocketURI);
        return endpoint;
    }
}
