package com.trading.upbit.ticker.dto.mapper;

import com.trading.upbit.ticker.domain.UpbitTicker;
import com.trading.upbit.ticker.dto.UpbitTickerResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UpbitTickerMapper {
    UpbitTicker map(UpbitTickerResponseDto tickerResponseDto);

}
