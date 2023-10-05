package com.trading.upbit.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MarketBaseInformation {

    @Id
    private long id;

    private String market;

    private String koreanName;

    private String englishName;

    private String marketWarning;
}
