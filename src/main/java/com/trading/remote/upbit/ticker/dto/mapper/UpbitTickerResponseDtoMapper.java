package com.trading.remote.upbit.ticker.dto.mapper;

import com.trading.remote.upbit.ticker.domain.UpbitTicker;
import com.trading.remote.upbit.ticker.dto.UpbitTickerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UpbitTickerResponseDtoMapper {

    List<UpbitTickerResponseDto> map(List<UpbitTicker> upbitTicker);
}
