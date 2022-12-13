package com.dk0124.cdr.repository.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.tick.BithumbTickDto;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTick;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTickUtils;
import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwAda;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbTickMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository.BithumbTickKrwAdaRepository;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository.BithumbTickRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbTickRepositoryUtils;
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
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationWithContainer
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BithumbTickTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbTickRepositoryUtils bithumbTickRepositoryUtils;

    @Autowired
    BithumbTickMapper bithumbTickMapper;

    @Autowired
    BithumbTickKrwAdaRepository adaRepo;


    @Test
    void empty() {
        assertNotNull(bithumbTickRepositoryUtils);
    }

    @BeforeAll
    public void save1000Ticks() {
        BithumbTickRepository repo = bithumbTickRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        for (int i = 0; i < 1000; i++) {
            BithumbTickDto dto = BithumbTickDto.builder()
                    .code(BithumbCoinCode.KRW_ADA.toString())
                    .contDtm(new Date(0))
                    .timestamp(Long.valueOf(i))
                    .build();
            repo.save(BithumbTickUtils.of(bithumbTickMapper.mapTick(dto)));
        }
    }

    @ParameterizedTest()
    @DisplayName("BithumbTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_bithumb_candles")
    void get_repository_from_code_and_save(BithumbTick c) {
        //g
        //w
        BithumbTickRepository repository =
                bithumbTickRepositoryUtils.getRepositoryFromCode(c.getCode());
        BithumbTick saved = repository.save(c);
        //t
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }

    static Stream<Arguments> get_each_bithumb_candles() {
        BithumbCoinCode[] codes = BithumbCoinCode.values();
        BithumbTick[] candles = new BithumbTick[codes.length];
        for (int i = 0; i < candles.length; i++) {
            BithumbTick c = BithumbTick
                    .builder()
                    .code(codes[i].toString())
                    .contDtm(new Date())
                    .timestamp(Long.valueOf(i))
                    .build();
            candles[i] = BithumbTickUtils.of(c);
        }
        return Arrays.stream(candles).map(c -> Arguments.of(c));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void query_less_than_timestamp() {
        //g

        //w
        BithumbTickRepository repo =
                bithumbTickRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbTick> list = repo.findByTimestampLessThanEqual(500L, pageRequest).getContent();

        //t
        assertEquals(200, list.size());
    }



    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, -1 번째 순서에 ")
    void query_less_than_timestamp_less_than_negative_1() {
        //g

        //w
        BithumbTickRepository repo =
                bithumbTickRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbTick> list = repo.findByTimestampLessThanEqual(-1L, pageRequest).getContent();

        //t
        assertEquals(0, list.size());

    }


}
