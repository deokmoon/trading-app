package com.trading.upbit.market.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarketBaseStorage {

    private static List<String> marketList = new ArrayList<>();

    public void save(MarketBaseInformation MarketBaseInformation) {
        marketList.add(MarketBaseInformation.getMarketCode());
    }

    public static List<String> getMarketList() {
        return marketList;
    }
}
