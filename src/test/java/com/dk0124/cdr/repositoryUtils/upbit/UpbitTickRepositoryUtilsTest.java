package com.dk0124.cdr.repositoryUtils.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTick;
import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTickUtils;
import com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository.UpbitTickRepository;
import com.dk0124.cdr.persistence.repositoryUtils.upbit.UpbitTickRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
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
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationWithContainer
@Transactional
class UpbitTickRepositoryUtilsTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");
    @Autowired
    UpbitTickRepositoryUtils upbitTickRepositoryUtils;

    @Test
    void empty() {
        assertNotNull(upbitTickRepositoryUtils);
    }



    @ParameterizedTest()
    @DisplayName("UpbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_ticks")
    void getRepositoryFromCode(UpbitTick t) {
        UpbitTickRepository tRepository = upbitTickRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.fromString(t.getCode()));
        UpbitTick saved = tRepository.save(t);
        assertNotNull(saved);
        assertEquals(t.getClass(),saved.getClass());
    }

    static Stream<Arguments> get_each_typed_upbit_ticks() {
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitTick[] ticks = new UpbitTick[codes.length];
        for (int i = 0; i < ticks.length; i++) {
            UpbitTick t = UpbitTick.builder().code(codes[i].toString()).sequentialId(Long.valueOf(i)).build();
            ticks[i] = UpbitTickUtils.of(t);
        }
        return Arrays.stream(ticks).map(t -> Arguments.of(t));
    }




    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void functionCreationWithPagable() {
        save1000Ticks();

        UpbitTickRepository repo =
                upbitTickRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        Page< UpbitTick> list = repo.findByTimestampLessThanEqual(500L, pageRequest);


        assertEquals(200,list.getContent().size());
    }

    private void save1000Ticks() {
        for (int i = 0; i < 1000; i++) {

            UpbitTick upbitTick = UpbitTick.builder()
                    .sequentialId(Long.valueOf(i))
                    .code(UpbitCoinCode.KRW_ADA.toString())
                    .timestamp(Long.valueOf(i))
                    .build();


            UpbitTickRepository repo =
                    upbitTickRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);

            repo.save(UpbitTickUtils.of(upbitTick));
        }
    }

}