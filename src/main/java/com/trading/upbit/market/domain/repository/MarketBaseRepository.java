package com.trading.upbit.market.domain.repository;

import com.trading.upbit.market.domain.MarketBaseInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketBaseRepository extends JpaRepository<MarketBaseInformation, Long> {
}
