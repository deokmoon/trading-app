package com.trading.client.dto.requests;

import lombok.Getter;

import java.util.List;

@Getter
public class UpbitTickerSocketRequest {
    private String ticket;
    private String type;
    private List<String> codes;
    private String format;
}
