package com.dk0124.cdr.mapper.upbit;

import com.dk0124.cdr.dto.upbit.orderbook.UpbitOrderbookDto;
import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderbook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UpbitOrderbookMapperTest {
    static UpbitOrderbookMapper upbitOrderbookMapper;
    static ObjectMapper objectMapper;

    String sampleOrderbookString = " {\n" +
            "    \"market\": \"KRW-BTC\",\n" +
            "    \"timestamp\": 1529910247984,\n" +
            "    \"total_ask_size\": 8.83621228,\n" +
            "    \"total_bid_size\": 2.43976741,\n" +
            "    \"orderbook_units\": [\n" +
            "      {\n" +
            "        \"ask_price\": 6956000,\n" +
            "        \"bid_price\": 6954000,\n" +
            "        \"ask_size\": 0.24078656,\n" +
            "        \"bid_size\": 0.00718341\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6958000,\n" +
            "        \"bid_price\": 6953000,\n" +
            "        \"ask_size\": 1.12919,\n" +
            "        \"bid_size\": 0.11500074\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6960000,\n" +
            "        \"bid_price\": 6952000,\n" +
            "        \"ask_size\": 0.08614137,\n" +
            "        \"bid_size\": 0.19019028\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6962000,\n" +
            "        \"bid_price\": 6950000,\n" +
            "        \"ask_size\": 0.0837203,\n" +
            "        \"bid_size\": 0.28201649\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6964000,\n" +
            "        \"bid_price\": 6949000,\n" +
            "        \"ask_size\": 0.501885,\n" +
            "        \"bid_size\": 0.01822085\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6965000,\n" +
            "        \"bid_price\": 6946000,\n" +
            "        \"ask_size\": 1.12517189,\n" +
            "        \"bid_size\": 0.0002\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6968000,\n" +
            "        \"bid_price\": 6945000,\n" +
            "        \"ask_size\": 2.89900477,\n" +
            "        \"bid_size\": 0.03597913\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6970000,\n" +
            "        \"bid_price\": 6944000,\n" +
            "        \"ask_size\": 0.2044231,\n" +
            "        \"bid_size\": 0.39291445\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6972000,\n" +
            "        \"bid_price\": 6939000,\n" +
            "        \"ask_size\": 2.55280097,\n" +
            "        \"bid_size\": 0.12963816\n" +
            "      },\n" +
            "      {\n" +
            "        \"ask_price\": 6974000,\n" +
            "        \"bid_price\": 6937000,\n" +
            "        \"ask_size\": 0.01308832,\n" +
            "        \"bid_size\": 1.2684239\n" +
            "      }\n" +
            "    ]\n" +
            "  }";

    @BeforeAll
    static void setup(){
        upbitOrderbookMapper = new UpbitOrderbookMapper(new ModelMapper());
        objectMapper = new ObjectMapper()  .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        assertNotNull(upbitOrderbookMapper);
    }

    @Test
    void map_candle_with_valid_input() throws JsonProcessingException {
        UpbitOrderbookDto dto = objectMapper.readValue(sampleOrderbookString,UpbitOrderbookDto.class);
        UpbitOrderbook orderbook = upbitOrderbookMapper.mapOrderbook(dto);
        assert orderbook instanceof UpbitOrderbook;
    }


    @Test
    @DisplayName("code 값이 없는 인풋에 매핑: assertThrows")
    void map_candle_with_invalid_input() throws JsonProcessingException {
        UpbitOrderbookDto dto = objectMapper.readValue(sampleOrderbookString,UpbitOrderbookDto.class);
        dto.setCode("");
        assertThrows(IllegalArgumentException.class,()->{
            upbitOrderbookMapper.mapOrderbook(dto);
        });
    }

}