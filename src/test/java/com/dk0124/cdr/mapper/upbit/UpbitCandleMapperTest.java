package com.dk0124.cdr.mapper.upbit;

import com.dk0124.cdr.dto.upbit.candle.UpbitCandleDto;
import com.dk0124.cdr.entity.upbit.candle.UpbitCandle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

class UpbitCandleMapperTest {

    static UpbitCandleMapper upbitCandleMapper;
    static ObjectMapper objectMapper;

    String sampleCandleString = " {\n" +
            "    \"market\": \"KRW-BTC\",\n" +
            "    \"candle_date_time_utc\": \"2018-04-18T10:16:00\",\n" +
            "    \"candle_date_time_kst\": \"2018-04-18T19:16:00\",\n" +
            "    \"opening_price\": 8615000,\n" +
            "    \"high_price\": 8618000,\n" +
            "    \"low_price\": 8611000,\n" +
            "    \"trade_price\": 8616000,\n" +
            "    \"timestamp\": 1524046594584,\n" +
            "    \"candle_acc_trade_price\": 60018891.90054,\n" +
            "    \"candle_acc_trade_volume\": 6.96780929,\n" +
            "    \"unit\": 1\n" +
            "  }";

    @BeforeAll
    static void setup(){
        upbitCandleMapper = new UpbitCandleMapper(new ModelMapper());
        objectMapper = new ObjectMapper()  .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        assertNotNull(upbitCandleMapper);
    }

    @Test
    void map_candle_with_valid_input() throws JsonProcessingException {
        UpbitCandleDto dto = objectMapper.readValue(sampleCandleString,UpbitCandleDto.class);
        UpbitCandle candle = upbitCandleMapper.mapCandle(dto);
        assert candle instanceof UpbitCandle;
    }


    @Test
    @DisplayName("code 값이 없는 인풋에 매핑: assertThrows")
    void map_candle_with_invalid_input() throws JsonProcessingException {
        UpbitCandleDto dto = objectMapper.readValue(sampleCandleString,UpbitCandleDto.class);
        dto.setMarket("");
        assertThrows(IllegalArgumentException.class,()->{
            upbitCandleMapper.mapCandle(dto);
        });
    }
}