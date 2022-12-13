package com.dk0124.cdr.persistence.mapper.upbit;

import com.dk0124.cdr.persistence.dto.upbit.tick.UpbitTickDto;
import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTick;
import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTickUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpbitTickMapper {
    private final ModelMapper mapper;
    public UpbitTick mapTick(UpbitTickDto dto){
        if(dto.getCode().isBlank())
            throw new IllegalArgumentException("can not convert dto with empty code : " + dto.toString());
        return UpbitTickUtils.of(mapper.map(dto, UpbitTick.class));
    }
}
