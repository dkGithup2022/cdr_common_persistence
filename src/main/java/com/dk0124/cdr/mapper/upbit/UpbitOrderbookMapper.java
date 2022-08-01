package com.dk0124.cdr.mapper.upbit;

import com.dk0124.cdr.dto.upbit.orderbook.UpbitOrderbookDto;
import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderBookFactory;
import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderbook;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpbitOrderbookMapper {
    private final ModelMapper mapper;
    public UpbitOrderbook mapOrderbook(UpbitOrderbookDto dto){
        if(dto.getCode().isBlank())
            throw new IllegalArgumentException("can not convert dto with empty code : " + dto.toString());
        if(dto.getTimestamp() == null)
            throw new IllegalArgumentException("can not convert dto with empty timestamp : " + dto.toString());
        return UpbitOrderBookFactory.of(mapper.map(dto, UpbitOrderbook.class));
    }
}
