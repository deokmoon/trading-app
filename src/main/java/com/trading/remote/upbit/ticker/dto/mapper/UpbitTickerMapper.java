package com.trading.remote.upbit.ticker.dto.mapper;

import com.trading.remote.upbit.ticker.domain.UpbitTicker;
import com.trading.remote.upbit.ticker.dto.UpbitTickerResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface UpbitTickerMapper {
    UpbitTicker map(UpbitTickerResponseDto tickerResponseDto);

}
