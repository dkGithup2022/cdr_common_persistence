package com.dk0124.cdr.persistence.mapper.bithumb;

import com.dk0124.cdr.persistence.dto.bithumb.candle.BithumbCandleDto;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandleFactory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BithumbCandleMapper {
    private final ModelMapper mapper;
    public BithumbCandle mapCandle(BithumbCandleDto dto){
        if(dto.getCode().isBlank())
            throw new IllegalArgumentException("can not convert dto with empty code : " + dto.toString());
        if(dto.getTimestamp()==null)
            throw new IllegalArgumentException("can not convert dto with empty timestamp : " + dto.toString());
        return BithumbCandleFactory.of(mapper.map(dto,BithumbCandle.class));
    }
}
