package com.trading.config;

import com.trading.config.socket.UpbitWebSocketClientEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration
public class WebSocketConfig {

    private final String upbitURL = "wss://api.upbit.com/websocket/v1";

    @Bean
    public UpbitWebSocketClientEndpoint upbitWebSocketClient() {
        UpbitWebSocketClientEndpoint endpoint = new UpbitWebSocketClientEndpoint();
        URI upbitWebSocketURI = URI.create(upbitURL);
        endpoint.connect(upbitWebSocketURI);
        return endpoint;
    }
}
