package com.trading.upbit.ticker.adapter;

import com.trading.config.WebsocketClientEndpoint;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.Session;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class UpbitStompSessionHandlerTest {


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
        String requestMessage = "[" +
                "{\"ticket\":\"test example\"}," +
                "{\"type\":\"ticker\",\"codes\":[\"KRW-BTC\", \"KRW-ETH\"], \"is_only_realtime\": \"true\"}," +
                "{\"format\":\"DEFAULT\"}" +
                "]";

        try {
            // open websocket
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint();
            Session session = clientEndPoint.connect(new URI(serverAddress));

            clientEndPoint.sendMessage(requestMessage);
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
            Thread.sleep(10000); // Wait for 10 seconds, for example

        } catch (InterruptedException ex) {
            System.err.println("InterruptedException exception: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.err.println("URISyntaxException exception: " + ex.getMessage());
        }
    }

    @Test
    final void java_socket() {

    }

}