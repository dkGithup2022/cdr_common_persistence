package com.dk0124.cdr.mapper.bithumb;

import com.dk0124.cdr.dto.bithumb.tick.BithumbTickDto;
import com.dk0124.cdr.entity.bithumb.tick.BithumbTick;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BithumbTickMapperTest {

    String sampleTick ="{\n" +
            "        \"symbol\" : \"BTC_KRW\"," +
            "            \"buySellGb\" : \"1\"," +
            "            \"contPrice\" : \"10579000\", " +
            "            \"contQty\" : \"0.01\"," +
            "            \"contAmt\" : \"105790.00\"," +
            "            \"contDtm\" : \"2020-01-29 12:24:18.830039\"," +
            "            \"updn\" : \"dn\"" +
            "    }";

    static BithumbTickMapper bithumbTickMapper;
    static ObjectMapper objectMapper;

    @BeforeAll
    static void setup() {
        bithumbTickMapper = new BithumbTickMapper(new ModelMapper());
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        assertNotNull(bithumbTickMapper);
    }

    @Test
    void map_tick_with_valid_input() throws JsonProcessingException {
        BithumbTickDto dto = objectMapper.readValue(sampleTick, BithumbTickDto.class);
        BithumbTick tick = bithumbTickMapper.mapTick(dto);
        System.out.println(tick);
        assert tick instanceof BithumbTick;
    }


    @Test
    @DisplayName("code 값이 없는 인풋에 매핑: assertThrows")
    void map_tick_with_invalid_input() throws JsonProcessingException {
        BithumbTickDto dto = objectMapper.readValue(sampleTick, BithumbTickDto.class);
        dto.setCode("");
        assertThrows(IllegalArgumentException.class, () -> {
            bithumbTickMapper.mapTick(dto);
        });
    }
}