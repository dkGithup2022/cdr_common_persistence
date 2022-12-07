package com.dk0124.cdr.repositoryPicker.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.persistence.entity.upbit.candle.UpbitCandle;
import com.dk0124.cdr.persistence.entity.upbit.candle.UpbitCandleFactory;
import com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository.UpbitCandleCommonJpaInterface;
import com.dk0124.cdr.persistence.repositoryPicker.upbit.UpbitCandleRepositoryPicker;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@IntegrationWithContainer
@Transactional
class UpbitCandleRepositoryPickerTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    UpbitCandleRepositoryPicker upbitTickRepositoryPicker;

    @Test
    void empty() {
        assertNotNull(upbitTickRepositoryPicker);
    }


    @ParameterizedTest()
    @DisplayName("UpbitCandleRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_candles")
    void getRepositoryFromCode(UpbitCandle c) {
        UpbitCandleCommonJpaInterface repository = upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.fromString(c.getMarket()));
        UpbitCandle saved = repository.save(c);
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }


    static Stream<Arguments> get_each_typed_upbit_candles() {
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitCandle[] candles = new UpbitCandle[codes.length];
        for (int i = 0; i < candles.length; i++) {
            UpbitCandle c = UpbitCandle.builder()
                    .market(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            candles[i] = UpbitCandleFactory.of(c);
        }
        return Arrays.stream(candles).map(c -> Arguments.of(c));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    @Disabled
    void functionCreationWithPagable() {
        save1000Candles();

        UpbitCandleCommonJpaInterface repo =
                upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        Page<UpbitCandle> list = repo.findByTimestampLessThanEqual(500L, pageRequest);


        assertEquals(200, list.getContent().size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 100 개 요청 성공 ")
    @Disabled
    void functionCreationWithPagable2() {
        save1000Candles();

        UpbitCandleCommonJpaInterface repo =
                upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        Page<UpbitCandle> list = repo.findByTimestampLessThanEqual(100L, pageRequest);


        System.out.println(list);
        assertEquals(101, list.getContent().size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / -1 개 요청 성공 ")
    @Disabled
    void functionCreationWithPagable3() {
        save1000Candles();

        UpbitCandleCommonJpaInterface repo =
                upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        Page<UpbitCandle> list = repo.findByTimestampLessThanEqual(-1L, pageRequest);


        System.out.println(list);
        System.out.println(list.getContent().size());
        assertEquals(0, list.getContent().size());
    }


    private void save1000Candles() {
        for (int i = 0; i < 1000; i++) {

            UpbitCandle candle = UpbitCandle
                    .builder()
                    .timestamp(Long.valueOf(i))
                    .market(UpbitCoinCode.KRW_ADA.toString())
                    .build();
            UpbitCandleCommonJpaInterface repo =
                    upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
            repo.save(UpbitCandleFactory.of(candle));
        }
    }

}