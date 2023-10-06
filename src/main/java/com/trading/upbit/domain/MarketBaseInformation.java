package com.trading.upbit.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarketBaseInformation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String market;
    private String koreanName;
    private String englishName;
    private String marketWarning;

    private MarketBaseInformation(String market, String koreanName, String englishName, String marketWarning) {
        this.market = market;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.marketWarning = marketWarning;
    }

    public static MarketBaseInformation of(String market, String koreanName, String englishName, String marketWarning) {
        return new MarketBaseInformation(market, koreanName, englishName, marketWarning);
    }
}
