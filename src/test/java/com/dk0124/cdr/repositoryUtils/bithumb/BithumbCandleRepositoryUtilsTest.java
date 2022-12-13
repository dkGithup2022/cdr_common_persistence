package com.dk0124.cdr.repositoryUtils.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.candle.BithumbCandleDto;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandleUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbCandleMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository.BithumbCandleCommonJpaInterface;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbCandleRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationWithContainer
@Transactional
class BithumbCandleRepositoryUtilsTest {
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

    @ParameterizedTest()
    @DisplayName("BithumbCandleRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_bithumb_candles")
    void getRepositoryFromCode(BithumbCandle c) {
        BithumbCandleCommonJpaInterface repository = bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.fromString(c.getCode()));
        BithumbCandle saved = repository.save(c);
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
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void functionCreationWithPagable() {
        save1000Candles();

        BithumbCandleCommonJpaInterface repo =
                bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbCandle> list = repo.findByTimestampLessThanEqual(500L, pageRequest).getContent();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println("first: " + list.get(0));
        System.out.println("last: " + list.get(list.size() - 1));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, 100 번째 순서에 ")
    void functionCreationWithPagabl2() {
        save1000Candles();

        BithumbCandleCommonJpaInterface repo =
                bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbCandle> list = repo.findByTimestampLessThanEqual(100L, pageRequest).getContent();


        System.out.println(list);
        System.out.println(list.size());
        System.out.println("first: " + list.get(0));
        System.out.println("last: " + list.get(list.size() - 1));

    }


    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, -1 번째 순서에 ")
    void functionCreationWithPagabl3() {
        save1000Candles();

        BithumbCandleCommonJpaInterface repo =
                bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbCandle> list = repo.findByTimestampLessThanEqual(-1L, pageRequest).getContent();

        assertEquals(0,list.size());

    }


    private void save1000Candles() {
        for (int i = 0; i < 1000; i++) {
            BithumbCandleDto dto = BithumbCandleDto.builder()
                    .code(BithumbCoinCode.KRW_ADA.toString())
                    .timestamp(Long.valueOf(i))
                    .build();

            BithumbCandleCommonJpaInterface repo =
                    bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.fromString(dto.getCode()));
            repo.save(BithumbCandleUtils.of(bithumbCandleMapper.mapCandle(dto)));
        }
    }

}