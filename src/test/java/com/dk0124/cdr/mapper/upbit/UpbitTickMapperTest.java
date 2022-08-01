package com.dk0124.cdr.mapper.upbit;

import com.dk0124.cdr.dto.upbit.tick.UpbitTickDto;
import com.dk0124.cdr.entity.upbit.tick.UpbitTick;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UpbitTickMapperTest {
    static UpbitTickMapper upbitTickMapper;
    static ObjectMapper objectMapper;

    String sampleTick = " {\n" +
            "    \"market\": \"KRW-BTC\",\n" +
            "    \"trade_date_utc\": \"2018-04-18\",\n" +
            "    \"trade_time_utc\": \"10:19:58\",\n" +
            "    \"timestamp\": 1524046798000,\n" +
            "    \"trade_price\": 8616000,\n" +
            "    \"trade_volume\": 0.03060688,\n" +
            "    \"prev_closing_price\": 8450000,\n" +
            "    \"chane_price\": 166000,\n" +
            "    \"ask_bid\": \"ASK\"\n" +
            "  }";
    @BeforeAll
    static void setup(){
        upbitTickMapper = new UpbitTickMapper(new ModelMapper());
        objectMapper = new ObjectMapper()  .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        assertNotNull(upbitTickMapper);
    }

    @Test
    void map_candle_with_valid_input() throws JsonProcessingException {
        UpbitTickDto dto = objectMapper.readValue(sampleTick,UpbitTickDto.class);
        UpbitTick candle = upbitTickMapper.mapTick(dto);
        assert candle instanceof UpbitTick;
    }


    @Test
    @DisplayName("code 값이 없는 인풋에 매핑: assertThrows")
    void map_candle_with_invalid_input() throws JsonProcessingException {
        UpbitTickDto dto = objectMapper.readValue(sampleTick,UpbitTickDto.class);
        dto.setCode("");
        assertThrows(IllegalArgumentException.class,()->{
            upbitTickMapper.mapTick(dto);
        });
    }
}