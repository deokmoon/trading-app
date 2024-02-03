package com.trading.domain.upbit.ticker.event;

import org.springframework.context.ApplicationEvent;

public class UpbitTicketEvent extends ApplicationEvent {
    private String message;

    public UpbitTicketEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

