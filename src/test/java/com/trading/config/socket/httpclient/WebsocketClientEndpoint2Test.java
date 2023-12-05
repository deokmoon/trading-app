package com.trading.config.socket.httpclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebsocketClientEndpoint2Test {

    @Autowired
    private WebsocketClientEndpoint2 websocketClientEndpoint2;

    @Test
    final void voidHttpClientTest() throws ExecutionException, InterruptedException {
        websocketClientEndpoint2.connect();
    }
}