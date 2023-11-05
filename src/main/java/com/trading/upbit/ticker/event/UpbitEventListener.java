package com.trading.upbit.ticker.event;

import com.trading.upbit.ticker.domain.UpbitTicker;
import com.trading.upbit.ticker.domain.UpbitTickerStorage;
import com.trading.upbit.ticker.dto.UpbitTickerResponseDto;
import com.trading.upbit.ticker.dto.mapper.UpbitTickerMapper;
import com.trading.util.ConvertStringToDto;
import org.mapstruct.factory.Mappers;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UpbitEventListener implements ApplicationListener<UpbitTicketEvent> {

    @Override
    public void onApplicationEvent(UpbitTicketEvent event) {
        System.out.println(event.getMessage());
        UpbitTickerResponseDto upbitTickerResponseDto = ConvertStringToDto.convertDtoFromJson(event.getMessage(), UpbitTickerResponseDto.class);
        UpbitTickerMapper mapper = Mappers.getMapper(UpbitTickerMapper.class);
        UpbitTicker upbitTicker = mapper.map(upbitTickerResponseDto);
        UpbitTickerStorage.save(upbitTicker.getCode(), upbitTicker);
    }
}
