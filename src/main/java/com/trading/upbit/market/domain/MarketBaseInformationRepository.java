package com.trading.upbit.market.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketBaseInformationRepository extends JpaRepository<MarketBaseInformation, Long> {

}
