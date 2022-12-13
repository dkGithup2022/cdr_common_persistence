package com.dk0124.cdr.persistence.mapper.bithumb;

import com.dk0124.cdr.persistence.dto.bithumb.orderbook.BithumbOrderbookDto;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbook;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbookUtils;
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
        return BithumbOrderbookUtils.of(mapper.map(dto, BithumbOrderbook.class));
    }
}
