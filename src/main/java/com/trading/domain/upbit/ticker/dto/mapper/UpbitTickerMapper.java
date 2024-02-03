package com.trading.domain.upbit.ticker.dto.mapper;

import com.trading.domain.upbit.ticker.domain.UpbitTicker;
import com.trading.domain.upbit.ticker.dto.UpbitTickerResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UpbitTickerMapper {
    UpbitTicker map(UpbitTickerResponseDto tickerResponseDto);

}
