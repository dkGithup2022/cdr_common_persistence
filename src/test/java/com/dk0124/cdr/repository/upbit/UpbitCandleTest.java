package com.dk0124.cdr.repository.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.candle.BithumbCandleDto;
import com.dk0124.cdr.persistence.dto.upbit.candle.UpbitCandleDto;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandleUtils;
import com.dk0124.cdr.persistence.entity.upbit.candle.UpbitCandle;
import com.dk0124.cdr.persistence.entity.upbit.candle.UpbitCandleUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbCandleMapper;
import com.dk0124.cdr.persistence.mapper.upbit.UpbitCandleMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository.BithumbCandleRepository;
import com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository.UpbitCandleRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbCandleRepositoryUtils;
import com.dk0124.cdr.persistence.repositoryUtils.upbit.UpbitCandleRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationWithContainer
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpbitCandleTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    UpbitCandleRepositoryUtils upbitCandleRepositoryUtils;

    @Autowired
    UpbitCandleMapper upbitCandleMapper;

    @Test
    void empty() {
        assertNotNull(upbitCandleRepositoryUtils);
    }

    @BeforeAll
    public void save1000Candles() {
        for (int i = 0; i < 1000; i++) {
            UpbitCandleDto dto = UpbitCandleDto.builder()
                    .market(UpbitCoinCode.KRW_ADA.toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            UpbitCandleRepository repo =
                    upbitCandleRepositoryUtils.getRepositoryFromCode(dto.getMarket());
            repo.save(UpbitCandleUtils.of(upbitCandleMapper.mapCandle(dto)));
        }
    }

    @ParameterizedTest()
    @DisplayName("UpbitCandleRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_upbit_candles")
    void get_repository_from_code_and_save(UpbitCandle c) {
        //g
        //w
        UpbitCandleRepository repository =
                upbitCandleRepositoryUtils.getRepositoryFromCode(c.getMarket());
        UpbitCandle saved = repository.save(c);
        //t
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }

    static Stream<Arguments> get_each_upbit_candles() {
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitCandle[] candles = new UpbitCandle[codes.length];
        for (int i = 0; i < candles.length; i++) {
            UpbitCandle c = UpbitCandle
                    .builder()
                    .market(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            candles[i] = UpbitCandleUtils.of(c);
        }
        return Arrays.stream(candles).map(c -> Arguments.of(c));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void query_less_than_timestamp() {
        //g

        //w
        UpbitCandleRepository repo =
                upbitCandleRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitCandle> list = repo.findByTimestampLessThanEqual(500L, pageRequest).getContent();

        //t
        assertEquals(200, list.size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 101개 반환 / ")
    void query_less_than_timestamp_less_than_100() {
        //g

        //w
        UpbitCandleRepository repo =
                upbitCandleRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitCandle> list = repo.findByTimestampLessThanEqual(100L, pageRequest).getContent();

        //t
        assertEquals(101, list.stream().map(e->e.getTimestamp()).distinct().count());
    }


    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, -1 번째 순서에 ")
    void query_less_than_timestamp_less_than_negative_1() {
        //g

        //w
        UpbitCandleRepository repo =
                upbitCandleRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitCandle> list = repo.findByTimestampLessThanEqual(-1L, pageRequest).getContent();

        //t
        assertEquals(0, list.size());

    }

}
