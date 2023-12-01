package com.trading.client.ui;

import com.trading.client.application.UpbitSocketService;
import com.trading.client.dto.requests.UpbitTickerSocketRequest;
import com.trading.client.dto.response.UpbitTickerSocketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SocketController {

    private final UpbitSocketService upbitSocketService;

    @MessageMapping("upbit/ticker")
    @SendTo("/topic/upbit/ticker")
    public List<UpbitTickerSocketResponse> handleTickerRequest(UpbitTickerSocketRequest tickerRequest) {
        return upbitSocketService.getUpbitTickerPrice(tickerRequest.getCodes().toArray(new String[0]));
    }
}
