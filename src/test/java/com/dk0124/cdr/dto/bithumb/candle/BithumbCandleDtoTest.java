package com.dk0124.cdr.dto.bithumb.candle;

import com.dk0124.cdr.entity.bithumb.candle.BithumbCandle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class BithumbCandleDtoTest {

    static ModelMapper mapper;


    @BeforeAll
    static void beforeAll() {
        mapper = new ModelMapper();
    }


    @Test
    @DisplayName("빈테스트 : cdr_common_persistence")
    void empty() {
    }


    @Test
    @DisplayName("dto 클래스 validation 검증 & dto class 빌드")
    void buildDtoWithValidation() {
        //given
        BithumbCandleDto dto = BithumbCandleDto.builder()
                .closingPrice(100.0)
                .highPrice(100.0)
                .lowPrice(100.0)
                .openingPrice(100.0)
                .timestamp(1000000L).build();

        BithumbCandle entity = mapper.map(dto,BithumbCandle.class);

        assertNotNull(dto);
        assertNotNull(entity);
        assertEquals(dto.getClosingPrice(),entity.getClosingPrice());
        assertEquals(dto.getCode(),entity.getCode());
    }
}