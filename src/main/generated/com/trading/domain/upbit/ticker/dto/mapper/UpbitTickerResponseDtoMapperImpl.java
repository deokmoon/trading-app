package com.trading.domain.upbit.ticker.dto.mapper;

import com.trading.domain.upbit.ticker.domain.UpbitTicker;
import com.trading.domain.upbit.ticker.dto.UpbitTickerResponseDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-21T10:14:53+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.9 (Eclipse Adoptium)"
)
public class UpbitTickerResponseDtoMapperImpl implements UpbitTickerResponseDtoMapper {

    @Override
    public List<UpbitTickerResponseDto> map(List<UpbitTicker> upbitTicker) {
        if ( upbitTicker == null ) {
            return null;
        }

        List<UpbitTickerResponseDto> list = new ArrayList<UpbitTickerResponseDto>( upbitTicker.size() );
        for ( UpbitTicker upbitTicker1 : upbitTicker ) {
            list.add( upbitTickerToUpbitTickerResponseDto( upbitTicker1 ) );
        }

        return list;
    }

    protected UpbitTickerResponseDto upbitTickerToUpbitTickerResponseDto(UpbitTicker upbitTicker) {
        if ( upbitTicker == null ) {
            return null;
        }

        UpbitTickerResponseDto upbitTickerResponseDto = new UpbitTickerResponseDto();

        upbitTickerResponseDto.setType( upbitTicker.getType() );
        upbitTickerResponseDto.setCode( upbitTicker.getCode() );
        upbitTickerResponseDto.setOpeningPrice( upbitTicker.getOpeningPrice() );
        upbitTickerResponseDto.setHighPrice( upbitTicker.getHighPrice() );
        upbitTickerResponseDto.setLowPrice( upbitTicker.getLowPrice() );
        upbitTickerResponseDto.setTradePrice( upbitTicker.getTradePrice() );
        upbitTickerResponseDto.setPrevClosingPrice( upbitTicker.getPrevClosingPrice() );
        upbitTickerResponseDto.setAccTradePrice( upbitTicker.getAccTradePrice() );
        upbitTickerResponseDto.setChange( upbitTicker.getChange() );
        upbitTickerResponseDto.setChangePrice( upbitTicker.getChangePrice() );
        upbitTickerResponseDto.setSignedChangePrice( upbitTicker.getSignedChangePrice() );
        upbitTickerResponseDto.setChangeRate( upbitTicker.getChangeRate() );
        upbitTickerResponseDto.setSignedChangeRate( upbitTicker.getSignedChangeRate() );
        upbitTickerResponseDto.setAskBid( upbitTicker.getAskBid() );
        upbitTickerResponseDto.setTradeVolume( upbitTicker.getTradeVolume() );
        upbitTickerResponseDto.setAccTradeVolume( upbitTicker.getAccTradeVolume() );
        upbitTickerResponseDto.setTradeDate( upbitTicker.getTradeDate() );
        upbitTickerResponseDto.setTradeTime( upbitTicker.getTradeTime() );
        upbitTickerResponseDto.setTradeTimestamp( upbitTicker.getTradeTimestamp() );
        upbitTickerResponseDto.setAccAskVolume( upbitTicker.getAccAskVolume() );
        upbitTickerResponseDto.setAccBidVolume( upbitTicker.getAccBidVolume() );
        upbitTickerResponseDto.setHighest52WeekPrice( upbitTicker.getHighest52WeekPrice() );
        upbitTickerResponseDto.setHighest52WeekDate( upbitTicker.getHighest52WeekDate() );
        upbitTickerResponseDto.setLowest52WeekPrice( upbitTicker.getLowest52WeekPrice() );
        upbitTickerResponseDto.setLowest52WeekDate( upbitTicker.getLowest52WeekDate() );
        upbitTickerResponseDto.setMarketState( upbitTicker.getMarketState() );
        upbitTickerResponseDto.setTradingSuspended( upbitTicker.isTradingSuspended() );
        upbitTickerResponseDto.setDelistingDate( upbitTicker.getDelistingDate() );
        upbitTickerResponseDto.setMarketWarning( upbitTicker.getMarketWarning() );
        upbitTickerResponseDto.setTimestamp( upbitTicker.getTimestamp() );
        upbitTickerResponseDto.setAccTradePrice24h( upbitTicker.getAccTradePrice24h() );
        upbitTickerResponseDto.setAccTradeVolume24h( upbitTicker.getAccTradeVolume24h() );
        upbitTickerResponseDto.setStreamType( upbitTicker.getStreamType() );

        return upbitTickerResponseDto;
    }
}
