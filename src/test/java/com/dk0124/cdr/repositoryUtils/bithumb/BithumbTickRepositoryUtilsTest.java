package com.dk0124.cdr.repositoryUtils.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTick;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTickUtils;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository.BithumbTickCommonJpaInterface;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbTickRepositoryUtils;
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
class BithumbTickRepositoryUtilsTest {

    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbTickRepositoryUtils bithumbTickRepositoryUtils;

    @Test
    void empty(){assertNotNull(bithumbTickRepositoryUtils);}

    @ParameterizedTest()
    @DisplayName("BithumbTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_candles")
    void getRepositoryFromCode(BithumbTick t){
       BithumbTickCommonJpaInterface repository =
               bithumbTickRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.fromString(t.getCode()));
        BithumbTick saved = repository.save(t);
        assertNotNull(saved);
        assertEquals(t.getClass(),saved.getClass());
    }

    static Stream<Arguments> get_each_typed_upbit_candles() {
        BithumbCoinCode[] codes = BithumbCoinCode.values();
        BithumbTick[] ticks = new BithumbTick[codes.length];
        for(int i =0 ; i< ticks.length ; i++){
            BithumbTick c = BithumbTick.builder()
                    .code(codes[i].toString())
                    .contDtm(new Date())
                    .timestamp(Long.valueOf(i))
                    .build();
            ticks[i] = BithumbTickUtils.of(c);
        }
        return Arrays.stream(ticks).map(t->Arguments.of(t));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void functionCreationWithPagable() {
        save1000Ticks();

        BithumbTickCommonJpaInterface repo =
                bithumbTickRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbTick> list = repo.findByTimestampLessThanEqual(500L, pageRequest).getContent();


        System.out.println(list);
        System.out.println(list.size());
        System.out.println("first: " + list.get(0));
        System.out.println("last: " + list.get(list.size() - 1));
        assertEquals(200,list.size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 100 개 요청 성공 ")
    void functionCreationWithPagable2() {
        save1000Ticks();

        BithumbTickCommonJpaInterface repo =
                bithumbTickRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbTick> list = repo.findByTimestampLessThanEqual(100L, pageRequest).getContent();


        System.out.println(list);
        System.out.println(list.size());
        System.out.println("first: " + list.get(0));
        System.out.println("last: " + list.get(list.size() - 1));
        assertEquals(101,list.size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / -1 개 요청 성공 ")
    void functionCreationWithPagable3() {
        save1000Ticks();

        BithumbTickCommonJpaInterface repo =
                bithumbTickRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<BithumbTick> list = repo.findByTimestampLessThanEqual(-1L, pageRequest).getContent();

        System.out.println(list);
        System.out.println(list.size());
        assertEquals(0,list.size());
    }



    private void save1000Ticks() {
        for (int i = 0; i < 1000; i++) {
            BithumbTick bithumbTick = BithumbTick.builder()
                    .code(BithumbCoinCode.KRW_ADA.toString())
                    .contDtm(new Date())
                    .timestamp(Long.valueOf(i))
                    .build();
            BithumbTickCommonJpaInterface repo =
                    bithumbTickRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);
            repo.save(BithumbTickUtils.of(bithumbTick));
        }
    }
}