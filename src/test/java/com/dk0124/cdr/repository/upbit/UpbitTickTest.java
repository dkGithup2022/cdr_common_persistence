package com.dk0124.cdr.repository.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.persistence.dto.upbit.orderbook.UpbitOrderbookDto;
import com.dk0124.cdr.persistence.dto.upbit.tick.UpbitTickDto;
import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderbook;
import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderbookUtils;
import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTick;
import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTickUtils;
import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwDot;
import com.dk0124.cdr.persistence.mapper.upbit.UpbitOrderbookMapper;
import com.dk0124.cdr.persistence.mapper.upbit.UpbitTickMapper;
import com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository.UpbitOrderbookRepository;
import com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository.UpbitTickKrwDotRepository;
import com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository.UpbitTickRepository;
import com.dk0124.cdr.persistence.repositoryUtils.upbit.UpbitOrderbookRepositoryUtils;
import com.dk0124.cdr.persistence.repositoryUtils.upbit.UpbitTickRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.modelmapper.ModelMapper;
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
public class UpbitTickTest {

    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    UpbitTickRepositoryUtils upbitTickRepositoryUtils;

    @Autowired
    UpbitTickMapper upbitTickMapper;

    @Test
    void empty() {
        assertNotNull(upbitTickRepositoryUtils);
    }

    @BeforeAll
    public void save1000Ticks() {
        for (int i = 0; i < 1000; i++) {
            UpbitTickDto dto = UpbitTickDto.builder()
                    .code(UpbitCoinCode.KRW_ADA.toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            UpbitTickRepository repo =
                    upbitTickRepositoryUtils.getRepositoryFromCode(dto.getCode());
            UpbitTick t = upbitTickMapper.mapTick(dto);
            t.setSequentialId(Long.valueOf(i));
            repo.save(UpbitTickUtils.of(t));
        }
    }

    @ParameterizedTest()
    @DisplayName("UpbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_upbit_candles")
    void get_repository_from_code_and_save(UpbitTick c) {
        //g
        //w
        UpbitTickRepository repository =
                upbitTickRepositoryUtils.getRepositoryFromCode(c.getCode());
        UpbitTick saved = repository.save(c);
        //t
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }

    static Stream<Arguments> get_each_upbit_candles() {
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitTick[] candles = new UpbitTick[codes.length];
        for (int i = 0; i < candles.length; i++) {
            UpbitTick c = UpbitTick
                    .builder()
                    .code(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .sequentialId(Long.valueOf(i))
                    .build();
            candles[i] = UpbitTickUtils.of(c);
        }
        return Arrays.stream(candles).map(c -> Arguments.of(c));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void query_less_than_timestamp() {
        //g

        //w
        UpbitTickRepository repo =
                upbitTickRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitTick> list = repo.findByTimestampLessThanEqual(500L, pageRequest).getContent();

        //t
        assertEquals(200, list.size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 101개 반환 / ")
    void query_less_than_timestamp_less_than_100() {
        //g

        //w
        UpbitTickRepository repo =
                upbitTickRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitTick> list = repo.findByTimestampLessThanEqual(100L, pageRequest).getContent();

        //t
        System.out.println(list);
        assertEquals(101, list.stream().map(e -> e.getTimestamp()).distinct().count());
    }


    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, -1 번째 순서에 ")
    void query_less_than_timestamp_less_than_negative_1() {
        //g

        //w
        UpbitTickRepository repo =
                upbitTickRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitTick> list = repo.findByTimestampLessThanEqual(-1L, pageRequest).getContent();

        //t
        assertEquals(0, list.size());
    }
}
