package com.dk0124.cdr.repositoryPicker.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.entity.bithumb.candle.BithumbCandleFactory;
import com.dk0124.cdr.repository.bithumb.bithumbCandleRepository.BithumbCandleCommonJpaInterface;
import com.dk0124.cdr.app.tags.IntegrationWithContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationWithContainer
class BithumbCandleRepositoryPickerTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbCandleRepositoryPicker bithumbCandleRepositoryPicker;

    @Test
    void empty(){assertNotNull(bithumbCandleRepositoryPicker);}

    @ParameterizedTest()
    @DisplayName("BithumbCandleRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_bithumb_candles")
    void getRepositoryFromCode(BithumbCandle c){
        BithumbCandleCommonJpaInterface repository = bithumbCandleRepositoryPicker.getRepositoryFromCode(BithumbCoinCode.fromString(c.getCode()));
        BithumbCandle saved = repository.save(c);
        assertNotNull(saved);
        assertEquals(c.getClass(),saved.getClass());
    }

    static Stream<Arguments> get_each_bithumb_candles(){
        BithumbCoinCode[] codes = BithumbCoinCode.values();
        BithumbCandle[] candles = new BithumbCandle[codes.length];
        for( int i =0 ;i<candles.length; i++){
            BithumbCandle c = BithumbCandle
                    .builder()
                    .code(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            candles[i] = BithumbCandleFactory.of(c);
        }
        return Arrays.stream(candles).map(c->Arguments.of(c));
    }

}