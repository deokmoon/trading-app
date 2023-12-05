package com.trading.config.socket;

/**
 * Server(Spring) -> Remote(Upbit) Socket 통신을 위한 Configuration 및 Bean
 */
//@Configuration
public class WebSocketClientConfig {

    private final String upbitURL = "wss://api.upbit.com/websocket/v1";

//    @Bean
//    public UpbitWebSocketClientEndpoint upbitWebSocketClient() {
//        UpbitWebSocketClientEndpoint endpoint = new UpbitWebSocketClientEndpoint();
//        URI upbitWebSocketURI = URI.create(upbitURL);
//        endpoint.connect(upbitWebSocketURI);
//        return endpoint;
//    }
}
