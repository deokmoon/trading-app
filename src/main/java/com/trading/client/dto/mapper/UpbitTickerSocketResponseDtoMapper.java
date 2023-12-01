package com.trading.client.dto.mapper;

import com.trading.client.dto.response.UpbitTickerSocketResponse;
import com.trading.upbit.ticker.domain.UpbitTicker;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UpbitTickerSocketResponseDtoMapper {
    List<UpbitTickerSocketResponse> map(List<UpbitTicker> upbitTicker);
}
