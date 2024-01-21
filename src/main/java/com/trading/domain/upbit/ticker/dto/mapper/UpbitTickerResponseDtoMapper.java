package com.trading.domain.upbit.ticker.dto.mapper;

import com.trading.domain.upbit.ticker.domain.UpbitTicker;
import com.trading.domain.upbit.ticker.dto.UpbitTickerResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UpbitTickerResponseDtoMapper {

    List<UpbitTickerResponseDto> map(List<UpbitTicker> upbitTicker);
}
