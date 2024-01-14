package com.trading.upbit.ticker.adapter;

import com.trading.common.base.DefaultTestProfile;
import com.trading.config.socket.WebsocketClientEndpoint;
import com.trading.upbit.ticker.dto.UpbitTickerRequestDto;
import jakarta.websocket.DeploymentException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class UpbitStompSessionHandlerTest implements DefaultTestProfile {

    @Autowired
    private WebsocketClientEndpoint upbitWebSocketClient;

    @Test
    final void wss_test() throws ExecutionException, InterruptedException {
//        WebSocketClient webSocketClient = new StandardWebSocketClient();
//        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);

//        StompSessionHandler sessionHandler = new UpbitStompSessionHandler();
//        stompClient.connect("wss://api.upbit.com/websocket/v1", sessionHandler).get();
    }

    @Test
    final void java_socket_test() throws URISyntaxException, DeploymentException, IOException {
        final String serverAddress = "wss://api.upbit.com/websocket/v1";
        // Send your request message
        UpbitTickerRequestDto requestDto = UpbitTickerRequestDto.builder()
                .ticket("test example")
                .type("ticker")
                .codes(Arrays.asList("KRW-BTC", "KRW-ETH"))
                .format("DEFAULT")
                .isOnlyRealtime(true)
                .build();
        String requestMessage = requestDto.toString();
        System.out.println("request: " + requestMessage);
//        "[" +
//                "{\"ticket\":\"test example\"}," +
//                "{\"type\":\"ticker\",\"codes\":[\"KRW-BTC\", \"KRW-ETH\"], \"is_only_realtime\": \"true\"}," +
//                "{\"format\":\"DEFAULT\"}" +
//                "]";
        try {
            // open websocket
//            upbitWebSocketClient.sendMessage(requestMessage);
            // add listener
//            WebsocketClientEndpoint.MessageHandler handler = message -> {
//                System.out.println("handle message");
//                System.out.println(message);
////                    JSONObject response = new JSONObject(message);
////                    String type = response.getString("type");
////                    String code = response.getString("code");
////                    double openingPrice = response.getDouble("opening_price");
//            };
//
//            clientEndPoint.addMessageHandler(handler);

            // Sleep for a reasonable amount of time to allow for responses
            Thread.sleep(1000); // Wait for 10 seconds, for example
        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        }
    }

}
