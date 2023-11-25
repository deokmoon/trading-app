package com.trading.remote.upbit.market.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarketBaseStorage {

    private static List<String> marketList = new ArrayList<>();

    public void save(MarketBaseInformation MarketBaseInformation) {
        marketList.add(MarketBaseInformation.getMarket());
    }

    public static List<String> getMarketList() {
        return marketList;
    }
}
