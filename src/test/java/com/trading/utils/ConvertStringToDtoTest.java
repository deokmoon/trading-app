package com.trading.utils;

import com.trading.domain.upbit.ticker.dto.UpbitTickerResponseDto;
import org.junit.jupiter.api.Test;

import static com.trading.utils.ConvertStringToDto.convertDtoFromJson;
import static org.assertj.core.api.Assertions.assertThat;

class ConvertStringToDtoTest {

    private final String code = "KRW-BTC";
    private final String json = "{\"type\":\"ticker\",\"code\":\""+code+"\",\"opening_price\":47030000.0000,\"high_price\":47045000.0000,\"low_price\":46836000.0000,\"trade_price\":46936000.0000,\"prev_closing_price\":47030000.00000000,\"acc_trade_price\":59006906224.798140000000,\"change\":\"FALL\",\"change_price\":94000.00000000,\"signed_change_price\":-94000.00000000,\"change_rate\":0.0019987242,\"signed_change_rate\":-0.0019987242,\"ask_bid\":\"BID\",\"trade_volume\":0.00361793,\"acc_trade_volume\":1257.06716233,\"trade_date\":\"20231101\",\"trade_time\":\"105107\",\"trade_timestamp\":1698835867457,\"acc_ask_volume\":685.23206829,\"acc_bid_volume\":571.83509404,\"highest_52_week_price\":47459000.0000,\"highest_52_week_date\":\"2023-10-24\",\"lowest_52_week_price\":20700000.00000000,\"lowest_52_week_date\":\"2022-12-30\",\"market_state\":\"ACTIVE\",\"is_trading_suspended\":false,\"delisting_date\":null,\"market_warning\":\"NONE\",\"timestamp\":1698835867481,\"acc_trade_price_24h\":161721927288.74458000,\"acc_trade_volume_24h\":3456.84193492,\"stream_type\":\"REALTIME\"}";

    @Test
    final void json_deserialization_test() {
        UpbitTickerResponseDto responseDtos = convertDtoFromJson(json, UpbitTickerResponseDto.class);
        assertThat(responseDtos.getCode()).isEqualTo(code);
//        List<UpbitTickerResponseDto> responseDtos = convertFromJson(json, UpbitTickerResponseDto.class);
    }

}
