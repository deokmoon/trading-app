package com.trading.domain.coin;


import com.trading.config.orm.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CoinBaseInfo")
public class Coin extends BaseTimeEntity {

    @Id
    private String coinId;

    private String code;

    private String contents;

    private String repository;

    private String mainSite;

    private String source;

    private String cretID;

    private String modID;

}
