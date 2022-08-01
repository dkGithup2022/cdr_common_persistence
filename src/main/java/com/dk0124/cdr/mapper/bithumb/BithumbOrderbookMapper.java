package com.dk0124.cdr.mapper.bithumb;

import com.dk0124.cdr.dto.bithumb.orderbook.BithumbOrderbookDto;
import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbook;
import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbookFactory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BithumbOrderbookMapper {
    private final ModelMapper mapper;
    public BithumbOrderbook mapOrderbook(BithumbOrderbookDto dto){
        if(dto.getCode().isBlank())
            throw new IllegalArgumentException("can not convert dto with empty code : " + dto.toString());
        return BithumbOrderbookFactory.of(mapper.map(dto, BithumbOrderbook.class));
    }
}
