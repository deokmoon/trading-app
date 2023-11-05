package com.trading.upbit.ticker.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class UpbitTickerStorage {

    private static ConcurrentHashMap<String, UpbitTicker> tickerStorage = new ConcurrentHashMap();

    public static void save(String modifyKey, UpbitTicker upbitTicker) {
        tickerStorage.compute(modifyKey, (currentKey, currentValue) -> {
            if (currentValue == null) {
                return upbitTicker;
            }
            return upbitTicker;
        });
    }

    public static List<UpbitTicker> getTicker(String... codes) {
        Map<String, List<UpbitTicker>> groupedMap = new HashMap<>();
        for (String code : codes) {
            tickerStorage.forEach((key, value) -> {
                if (key.equals(code)) {
                    groupedMap.computeIfAbsent(code, k -> new ArrayList<>()).add(value);
                }
            });
        }

        List<UpbitTicker> resultList = groupedMap.values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return resultList;
    }

}
