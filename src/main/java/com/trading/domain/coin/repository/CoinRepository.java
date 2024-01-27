package com.trading.domain.coin.repository;


import com.trading.domain.coin.Coin;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CoinRepository extends Repository<Coin, String> {

    Coin save(Coin coin);

    Optional<Coin> findByCoinId(String coinId);

    void deleteByCoinId(String coinId);

}
