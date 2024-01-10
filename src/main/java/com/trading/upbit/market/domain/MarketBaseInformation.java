package com.trading.upbit.market.domain;

import com.trading.config.orm.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "crypto_base")
public class MarketBaseInformation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String marketCode;
    private String koreanName;
    private String englishName;
    private String marketWarning;

    private MarketBaseInformation(String marketCode, String koreanName, String englishName, String marketWarning) {
        this.marketCode = marketCode;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.marketWarning = marketWarning;
    }

    public static MarketBaseInformation of(String market, String koreanName, String englishName, String marketWarning) {
        return new MarketBaseInformation(market, koreanName, englishName, marketWarning);
    }
}
