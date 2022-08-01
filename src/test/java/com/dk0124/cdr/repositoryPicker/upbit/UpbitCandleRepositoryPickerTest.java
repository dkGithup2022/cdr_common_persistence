package com.dk0124.cdr.repositoryPicker.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.entity.upbit.candle.UpbitCandle;
import com.dk0124.cdr.entity.upbit.candle.UpbitCandleFactory;
import com.dk0124.cdr.entity.upbit.tick.UpbitTick;
import com.dk0124.cdr.entity.upbit.tick.UpbitTickFactory;
import com.dk0124.cdr.repository.upbit.upbitCandleRepository.UpbitCandleCommonJpaInterface;
import com.dk0124.cdr.repository.upbit.upbitTickRepository.UpbitTickKrwAdaRepository;
import com.dk0124.cdr.repository.upbit.upbitTickRepository.UpbitTickRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
class UpbitCandleRepositoryPickerTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    UpbitCandleRepositoryPicker upbitTickRepositoryPicker;

    @Test
    void empty(){ assertNotNull(upbitTickRepositoryPicker);}


    @ParameterizedTest()
    @DisplayName("UpbitCandleRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_candles")
    void getRepositoryFromCode(UpbitCandle c){
        UpbitCandleCommonJpaInterface repository = upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.fromString(c.getMarket()));
        UpbitCandle saved = repository.save(c);
        assertNotNull(saved);
        assertEquals(c.getClass(),saved.getClass());
    }


    static Stream<Arguments> get_each_typed_upbit_candles() {
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitCandle[] candles = new UpbitCandle[codes.length];
        for(int i =0 ; i< candles.length ; i++){
            UpbitCandle c = UpbitCandle.builder()
                    .market(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            candles[i] = UpbitCandleFactory.of(c);
        }
        return Arrays.stream(candles).map(c->Arguments.of(c));
    }

}