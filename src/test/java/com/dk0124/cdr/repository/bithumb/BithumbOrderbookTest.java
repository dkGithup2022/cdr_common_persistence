package com.dk0124.cdr.repository.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.orderbook.BithumbOrderbookDto;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbook;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbookUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbOrderbookMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository.BithumbOrderbookRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbOrderbookRepositoryUtils;
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationWithContainer
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BithumbOrderbookTest {

    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbOrderbookRepositoryUtils bithumbOrderbookRepositoryUtils;

    @Autowired
    BithumbOrderbookMapper bithumbOrderbookMapper;

    @Test
    void empty() {
        assertNotNull(bithumbOrderbookRepositoryUtils);
    }

    @BeforeAll
    public void save1000Orderbooks() {
        for (int i = 0; i < 1000; i++) {
            BithumbOrderbookDto dto = BithumbOrderbookDto.builder()
                    .code(BithumbCoinCode.KRW_ADA.toString())
                    .datetime(Long.valueOf(i))
                    .build();
            BithumbOrderbookRepository repo =
                    bithumbOrderbookRepositoryUtils.getRepositoryFromCode(dto.getCode());
            repo.save(BithumbOrderbookUtils.of(bithumbOrderbookMapper.mapOrderbook(dto)));
        }
    }

    @ParameterizedTest()
    @DisplayName("BithumbOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_bithumb_candles")
    void get_repository_from_code_and_save(BithumbOrderbook c) {
        //g
        //w
        BithumbOrderbookRepository repository =
                bithumbOrderbookRepositoryUtils.getRepositoryFromCode(c.getCode());
        BithumbOrderbook saved = repository.save(c);
        //t
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }

    static Stream<Arguments> get_each_bithumb_candles() {
        BithumbCoinCode[] codes = BithumbCoinCode.values();
        BithumbOrderbook[] candles = new BithumbOrderbook[codes.length];
        for (int i = 0; i < candles.length; i++) {
            BithumbOrderbook c = BithumbOrderbook
                    .builder()
                    .code(codes[i].toString())
                    .datetime(Long.valueOf(i))
                    .build();
            candles[i] = BithumbOrderbookUtils.of(c);
        }
        return Arrays.stream(candles).map(c -> Arguments.of(c));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void query_less_than_timestamp() {
        //g

        //w
        BithumbOrderbookRepository repo =
                bithumbOrderbookRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("datetime").descending());
        List<BithumbOrderbook> list = repo.findByDatetimeLessThanEqual(500L, pageRequest).getContent();

        //t
        assertEquals(200, list.size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 101개 반환 / ")
    void query_less_than_timestamp_less_than_100() {
        //g

        //w
        BithumbOrderbookRepository repo =
                bithumbOrderbookRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("datetime").descending());
        List<BithumbOrderbook> list = repo.findByDatetimeLessThanEqual(100L, pageRequest).getContent();

        //t
        System.out.println(list);
        assertEquals(101, list.stream().map(e->e.getDatetime()).distinct().count());
    }


    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, -1 번째 순서에 ")
    void query_less_than_timestamp_less_than_negative_1() {
        //g

        //w
        BithumbOrderbookRepository repo =
                bithumbOrderbookRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("datetime").descending());
        List<BithumbOrderbook> list = repo.findByDatetimeLessThanEqual(-1L, pageRequest).getContent();

        //t
        assertEquals(0, list.size());

    }

}
