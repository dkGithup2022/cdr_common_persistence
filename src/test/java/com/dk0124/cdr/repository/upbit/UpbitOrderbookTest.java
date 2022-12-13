package com.dk0124.cdr.repository.upbit;


import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.orderbook.BithumbOrderbookDto;
import com.dk0124.cdr.persistence.dto.upbit.orderbook.UpbitOrderbookDto;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbook;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbookUtils;
import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderbook;
import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderbookUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbOrderbookMapper;
import com.dk0124.cdr.persistence.mapper.upbit.UpbitOrderbookMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository.BithumbOrderbookRepository;
import com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository.UpbitOrderbookRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbOrderbookRepositoryUtils;
import com.dk0124.cdr.persistence.repositoryUtils.upbit.UpbitOrderbookRepositoryUtils;
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
public class UpbitOrderbookTest {

    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    UpbitOrderbookRepositoryUtils upbitOrderbookRepositoryUtils;

    @Autowired
    UpbitOrderbookMapper upbitOrderbookMapper;

    @Test
    void empty() {
        assertNotNull(upbitOrderbookRepositoryUtils);
    }

    @BeforeAll
    public void save1000Orderbooks() {
        for (int i = 0; i < 1000; i++) {
            UpbitOrderbookDto dto = UpbitOrderbookDto.builder()
                    .code(UpbitCoinCode.KRW_ADA.toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            UpbitOrderbookRepository repo =
                    upbitOrderbookRepositoryUtils.getRepositoryFromCode(dto.getCode());
            repo.save(UpbitOrderbookUtils.of(upbitOrderbookMapper.mapOrderbook(dto)));
        }
    }

    @ParameterizedTest()
    @DisplayName("UpbitOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_upbit_candles")
    void get_repository_from_code_and_save(UpbitOrderbook c) {
        //g
        //w
        UpbitOrderbookRepository repository =
                upbitOrderbookRepositoryUtils.getRepositoryFromCode(c.getCode());
        UpbitOrderbook saved = repository.save(c);
        //t
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }

    static Stream<Arguments> get_each_upbit_candles() {
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitOrderbook[] candles = new UpbitOrderbook[codes.length];
        for (int i = 0; i < candles.length; i++) {
            UpbitOrderbook c = UpbitOrderbook
                    .builder()
                    .code(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            candles[i] = UpbitOrderbookUtils.of(c);
        }
        return Arrays.stream(candles).map(c -> Arguments.of(c));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void query_less_than_timestamp() {
        //g

        //w
        UpbitOrderbookRepository repo =
                upbitOrderbookRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitOrderbook> list = repo.findByTimestampLessThanEqual(500L, pageRequest).getContent();

        //t
        assertEquals(200, list.size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 101개 반환 / ")
    void query_less_than_timestamp_less_than_100() {
        //g

        //w
        UpbitOrderbookRepository repo =
                upbitOrderbookRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitOrderbook> list = repo.findByTimestampLessThanEqual(100L, pageRequest).getContent();

        //t
        System.out.println(list);
        assertEquals(101, list.stream().map(e -> e.getTimestamp()).distinct().count());
    }


    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, -1 번째 순서에 ")
    void query_less_than_timestamp_less_than_negative_1() {
        //g

        //w
        UpbitOrderbookRepository repo =
                upbitOrderbookRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitOrderbook> list = repo.findByTimestampLessThanEqual(-1L, pageRequest).getContent();

        //t
        assertEquals(0, list.size());
    }
}
