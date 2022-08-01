package com.dk0124.cdr.mapper.bithumb;

import com.dk0124.cdr.dto.bithumb.orderbook.BithumbOrderbookDto;
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

class BithumbOrderbookMapperTest {

    static BithumbOrderbookMapper bithumbOrderbookMapper;
    static ObjectMapper objectMapper;

    String sampleOrderbookString = " {\n" +
            "            \"symbol\" : \"BTC_KRW\",\n" +
            "            \"total\" : \"3\",\n" +
            "            \"datetime\":1580268255864325,\n" +
            "        \"orderbookUnit\":[\n" +
            "        {\"symbol\" : \"BTC_KRW\", \"orderType\" : \"ask\", \"price\" : \"10596000\", \"quantity\" : \"0.5495\", \"total\" : \"8\"},\n" +
            "        {\"symbol\" : \"BTC_KRW\", \"orderType\" : \"ask\", \"price\" : \"10598000\", \"quantity\" : \"18.2085\", \"total\" : \"10\"},\n" +
            "        {\"symbol\" : \"BTC_KRW\", \"orderType\" : \"bid\", \"price\" : \"10532000\", \"quantity\" : \"0\", \"total\" : \"0\"},\n" +
            "        {\"symbol\" : \"BTC_KRW\", \"orderType\" : \"bid\", \"price\" : \"10572000\", \"quantity\" : \"2.3324\", \"total\" : \"4\"},\n" +
            "        {\"symbol\" : \"BTC_KRW\", \"orderType\" : \"bid\", \"price\" : \"10571000\", \"quantity\" : \"1.469\", \"total\" : \"3\"},\n" +
            "        {\"symbol\" : \"BTC_KRW\", \"orderType\" : \"bid\", \"price\" : \"10569000\", \"quantity\" : \"0.5152\", \"total\" : \"2\"}\n" +
            "                ]\n" +
            "    }";


    @BeforeAll
    static void setup() {
        bithumbOrderbookMapper = new BithumbOrderbookMapper(new ModelMapper());
        objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        assertNotNull(bithumbOrderbookMapper);
    }

    @Test
    void map_orderbook_with_valid_input() throws JsonProcessingException {
        BithumbOrderbookDto dto = objectMapper.readValue(sampleOrderbookString, BithumbOrderbookDto.class);
        BithumbOrderbook orderbook = bithumbOrderbookMapper.mapOrderbook(dto);
        System.out.println(orderbook);
        assert orderbook instanceof BithumbOrderbook;
    }


    @Test
    @DisplayName("code 값이 없는 인풋에 매핑: assertThrows")
    void map_orderbook_with_invalid_input() throws JsonProcessingException {
        BithumbOrderbookDto dto = objectMapper.readValue(sampleOrderbookString, BithumbOrderbookDto.class);
        dto.setCode("");
        assertThrows(IllegalArgumentException.class, () -> {
            bithumbOrderbookMapper.mapOrderbook(dto);
        });
    }

}