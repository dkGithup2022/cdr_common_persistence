package com.dk0124.cdr.repository.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.candle.BithumbCandleDto;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandleUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbCandleMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository.BithumbCandleRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbCandleRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationWithContainer
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BithumbCandleTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbCandleRepositoryUtils bithumbCandleRepositoryUtils;

    @Autowired
    BithumbCandleMapper bithumbCandleMapper;

    @Test
    void empty() {
        assertNotNull(bithumbCandleRepositoryUtils);
    }

    @BeforeAll
    public void save1000Candles() {
        for (int i = 0; i < 1000; i++) {
            BithumbCandleDto dto = BithumbCandleDto.builder()
                    .code(BithumbCoinCode.KRW_ADA.toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            BithumbCandleRepository repo =
                    bithumbCandleRepositoryUtils.getRepositoryFromCode(dto.getCode());
            repo.save(BithumbCandleUtils.of(bithumbCandleMapper.mapCandle(dto)));
        }
    }

    @ParameterizedTest()
    @DisplayName("BithumbCandleRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) ?????????")
    @MethodSource("get_each_bithumb_candles")
    void get_repository_from_code_and_save(BithumbCandle c) {
        //g
        //w
        BithumbCandleRepository repository =
                bithumbCandleRepositoryUtils.getRepositoryFromCode(c.getCode());
        BithumbCandle saved = repository.save(c);
        //t
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }

    static Stream<Arguments> get_each_bithumb_candles() {
        BithumbCoinCode[] codes = BithumbCoinCode.values();
        BithumbCandle[] candles = new BithumbCandle[codes.length];
        for (int i = 0; i < candles.length; i++) {
            BithumbCandle c = BithumbCandle
                    .builder()
                    .code(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            candles[i] = BithumbCandleUtils.of(c);
        }
        return Arrays.stream(candles).map(c -> Arguments.of(c));
    }

    @Test
    @DisplayName("?????? ?????????, timestamp ?????? creation query ????????? / 200 ??? ?????? ?????? ")
    void query_less_than_timestamp() {
        //g

        //w
        BithumbCandleRepository repo =
                bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbCandle> list = repo.findByTimestampLessThanEqual(500L, pageRequest).getContent();

        //t
        assertEquals(200, list.size());
    }

    @Test
    @DisplayName("?????? ?????????, timestamp ?????? creation query ????????? / 101??? ?????? / ")
    void query_less_than_timestamp_less_than_100() {
        //g

        //w
        BithumbCandleRepository repo =
                bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbCandle> list = repo.findByTimestampLessThanEqual(100L, pageRequest).getContent();

        //t
        assertEquals(101, list.stream().map(e->e.getTimestamp()).distinct().count());
    }


    @Test
    @DisplayName("?????? ?????????, timestamp ?????? creation query ????????? / 200 ??? ??????, -1 ?????? ????????? ")
    void query_less_than_timestamp_less_than_negative_1() {
        //g

        //w
        BithumbCandleRepository repo =
                bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbCandle> list = repo.findByTimestampLessThanEqual(-1L, pageRequest).getContent();

        //t
        assertEquals(0, list.size());

    }
}
