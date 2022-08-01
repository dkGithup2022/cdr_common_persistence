package com.dk0124.cdr.mapper.upbit;


import com.dk0124.cdr.dto.upbit.candle.UpbitCandleDto;
import com.dk0124.cdr.entity.upbit.candle.UpbitCandle;
import com.dk0124.cdr.entity.upbit.candle.UpbitCandleFactory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UpbitCandleMapper {
    private final ModelMapper mapper;
    public UpbitCandle mapCandle(UpbitCandleDto dto){
        if(dto.getMarket().isBlank())
            throw new IllegalArgumentException("can not convert dto with empty code : " + dto.toString());
        if(dto.getTimestamp() == null)
            throw new IllegalArgumentException("can not convert dto with empty timestamp : " + dto.toString());
        return UpbitCandleFactory.of(mapper.map(dto, UpbitCandle.class));
    }
}
