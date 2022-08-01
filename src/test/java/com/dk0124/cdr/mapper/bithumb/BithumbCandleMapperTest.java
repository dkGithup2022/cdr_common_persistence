package com.dk0124.cdr.mapper.bithumb;

import com.dk0124.cdr.dto.bithumb.candle.BithumbCandleDto;
import com.dk0124.cdr.dto.bithumb.orderbook.BithumbOrderbookDto;
import com.dk0124.cdr.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BithumbCandleMapperTest {

    static BithumbCandleMapper bithumbCandleMapper;
    static ObjectMapper objectMapper;

    String sampleCandle = "{\n" +
            "            \"code\":\"BTC_KRW\",\n" +
            "                \"timestamp\": 10000,\n" +
            "            \"openingPrice\": 10000,\n" +
            "            \"highPrice\":10000,\n" +
            "            \"closingPrice\":10000,\n" +
            "            \"lowPrice\":10000,\n" +
            "            \"tradeAmount\":10000\n" +
            "    }";


    @BeforeAll
    static void setup() {
        bithumbCandleMapper = new BithumbCandleMapper(new ModelMapper());
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        assertNotNull(bithumbCandleMapper);
    }

    @Test
    void map_orderbook_with_valid_input() throws JsonProcessingException {
        BithumbCandleDto dto = objectMapper.readValue(sampleCandle, BithumbCandleDto.class);
        BithumbCandle candle = bithumbCandleMapper.mapCandle(dto);
        assert candle instanceof BithumbCandle;
    }


    @Test
    @DisplayName("code 값이 없는 인풋에 매핑: assertThrows")
    void map_orderbook_with_invalid_input() throws JsonProcessingException {
        BithumbCandleDto dto = objectMapper.readValue(sampleCandle, BithumbCandleDto.class);
        dto.setCode("");
        assertThrows(IllegalArgumentException.class, () -> {
            bithumbCandleMapper.mapCandle(dto);
        });
    }

}