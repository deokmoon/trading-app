package com.trading.config.socket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * https://docs.spring.io/spring-framework/reference/web/websocket/stomp.html
 * Client -> Server(Spring) pub/sub 을 위한 Socket 통신 Configuration
 */
@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//public class WebSocketConfig {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket/v1").setAllowedOrigins("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // spring -> client 보낼 때 prefix
        config.setApplicationDestinationPrefixes("/app"); // client 가 보낼 때 url의 prefix
    }
}
