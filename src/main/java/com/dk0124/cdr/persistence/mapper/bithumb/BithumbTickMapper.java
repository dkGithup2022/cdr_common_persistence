package com.dk0124.cdr.persistence.mapper.bithumb;

import com.dk0124.cdr.persistence.dto.bithumb.tick.BithumbTickDto;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTick;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTickUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BithumbTickMapper {
    private final ModelMapper mapper;
    public BithumbTick mapTick(BithumbTickDto dto){
        if(dto.getCode().isBlank())
            throw new IllegalArgumentException("can not convert dto with empty code : " + dto.toString());
        makeTimeStamp(dto);
        return BithumbTickUtils.of(mapper.map(dto, BithumbTick.class));
    }

    private void makeTimeStamp(BithumbTickDto dto) {
        dto.setTimestamp(dto.getContDtm().getTime());
    }
}
