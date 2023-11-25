package com.trading.remote.upbit.ticker.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpbitTickerEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(final String message) {
        UpbitTicketEvent upbitTicketEvent = new UpbitTicketEvent(this, message);
        applicationEventPublisher.publishEvent(upbitTicketEvent);
    }
}