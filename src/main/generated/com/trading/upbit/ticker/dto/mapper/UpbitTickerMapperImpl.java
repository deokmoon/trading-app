package com.trading.upbit.ticker.dto.mapper;

import com.trading.upbit.ticker.domain.UpbitTicker;
import com.trading.upbit.ticker.dto.UpbitTickerResponseDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-10T20:42:49+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class UpbitTickerMapperImpl implements UpbitTickerMapper {

    @Override
    public UpbitTicker map(UpbitTickerResponseDto tickerResponseDto) {
        if ( tickerResponseDto == null ) {
            return null;
        }

        UpbitTicker upbitTicker = new UpbitTicker();

        upbitTicker.setType( tickerResponseDto.getType() );
        upbitTicker.setCode( tickerResponseDto.getCode() );
        upbitTicker.setOpeningPrice( tickerResponseDto.getOpeningPrice() );
        upbitTicker.setHighPrice( tickerResponseDto.getHighPrice() );
        upbitTicker.setLowPrice( tickerResponseDto.getLowPrice() );
        upbitTicker.setTradePrice( tickerResponseDto.getTradePrice() );
        upbitTicker.setPrevClosingPrice( tickerResponseDto.getPrevClosingPrice() );
        upbitTicker.setAccTradePrice( tickerResponseDto.getAccTradePrice() );
        upbitTicker.setChange( tickerResponseDto.getChange() );
        upbitTicker.setChangePrice( tickerResponseDto.getChangePrice() );
        upbitTicker.setSignedChangePrice( tickerResponseDto.getSignedChangePrice() );
        upbitTicker.setChangeRate( tickerResponseDto.getChangeRate() );
        upbitTicker.setSignedChangeRate( tickerResponseDto.getSignedChangeRate() );
        upbitTicker.setAskBid( tickerResponseDto.getAskBid() );
        upbitTicker.setTradeVolume( tickerResponseDto.getTradeVolume() );
        upbitTicker.setAccTradeVolume( tickerResponseDto.getAccTradeVolume() );
        upbitTicker.setTradeDate( tickerResponseDto.getTradeDate() );
        upbitTicker.setTradeTime( tickerResponseDto.getTradeTime() );
        upbitTicker.setTradeTimestamp( tickerResponseDto.getTradeTimestamp() );
        upbitTicker.setAccAskVolume( tickerResponseDto.getAccAskVolume() );
        upbitTicker.setAccBidVolume( tickerResponseDto.getAccBidVolume() );
        upbitTicker.setHighest52WeekPrice( tickerResponseDto.getHighest52WeekPrice() );
        upbitTicker.setHighest52WeekDate( tickerResponseDto.getHighest52WeekDate() );
        upbitTicker.setLowest52WeekPrice( tickerResponseDto.getLowest52WeekPrice() );
        upbitTicker.setLowest52WeekDate( tickerResponseDto.getLowest52WeekDate() );
        upbitTicker.setMarketState( tickerResponseDto.getMarketState() );
        upbitTicker.setTradingSuspended( tickerResponseDto.isTradingSuspended() );
        upbitTicker.setDelistingDate( tickerResponseDto.getDelistingDate() );
        upbitTicker.setMarketWarning( tickerResponseDto.getMarketWarning() );
        upbitTicker.setTimestamp( tickerResponseDto.getTimestamp() );
        upbitTicker.setAccTradePrice24h( tickerResponseDto.getAccTradePrice24h() );
        upbitTicker.setAccTradeVolume24h( tickerResponseDto.getAccTradeVolume24h() );
        upbitTicker.setStreamType( tickerResponseDto.getStreamType() );

        return upbitTicker;
    }
}
