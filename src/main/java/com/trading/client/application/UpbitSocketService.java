package com.trading.client.application;

import com.trading.client.dto.mapper.UpbitTickerSocketResponseDtoMapper;
import com.trading.client.dto.response.UpbitTickerSocketResponse;
import com.trading.upbit.ticker.domain.UpbitTicker;
import com.trading.upbit.ticker.domain.UpbitTickerStorage;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpbitSocketService {

    public List<UpbitTickerSocketResponse> getUpbitTickerPrice(String... markets) {
        List<UpbitTicker> upbitTicker = UpbitTickerStorage.getTicker(markets);
        UpbitTickerSocketResponseDtoMapper mapper = Mappers.getMapper(UpbitTickerSocketResponseDtoMapper.class);
        return mapper.map(upbitTicker);
    }
}
