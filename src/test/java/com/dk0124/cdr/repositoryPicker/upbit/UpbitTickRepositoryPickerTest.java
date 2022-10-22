package com.dk0124.cdr.repositoryPicker.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.entity.bithumb.tick.BithumbTick;
import com.dk0124.cdr.entity.bithumb.tick.BithumbTickFactory;
import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderbook;
import com.dk0124.cdr.entity.upbit.tick.UpbitTick;
import com.dk0124.cdr.entity.upbit.tick.UpbitTickFactory;
import com.dk0124.cdr.repository.bithumb.bithumbTickRepository.BithumbTickCommonJpaInterface;
import com.dk0124.cdr.repository.upbit.upbitOrderBookRepository.UpbitOrderbookCommonRepository;
import com.dk0124.cdr.repository.upbit.upbitTickRepository.UpbitTickRepository;
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
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationWithContainer
@Transactional
class UpbitTickRepositoryPickerTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");
    @Autowired
    UpbitTickRepositoryPicker upbitTickRepositoryPicker;

    @Test
    void empty() {
        assertNotNull(upbitTickRepositoryPicker);
    }



    @ParameterizedTest()
    @DisplayName("UpbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_ticks")
    void getRepositoryFromCode(UpbitTick t) {
        UpbitTickRepository tRepository = upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.fromString(t.getCode()));
        UpbitTick saved = tRepository.save(t);
        assertNotNull(saved);
        assertEquals(t.getClass(),saved.getClass());
    }

    static Stream<Arguments> get_each_typed_upbit_ticks() {
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitTick[] ticks = new UpbitTick[codes.length];
        for (int i = 0; i < ticks.length; i++) {
            UpbitTick t = UpbitTick.builder().code(codes[i].toString()).sequentialId(Long.valueOf(i)).build();
            ticks[i] = UpbitTickFactory.of(t);
        }
        return Arrays.stream(ticks).map(t -> Arguments.of(t));
    }




    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void functionCreationWithPagable() {
        save1000Ticks();

        UpbitTickRepository repo =
                upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitTick> list = repo.findByTimestampLessThanEqual(500L, pageRequest);


        System.out.println(list);
        System.out.println(list.size());
        System.out.println("first: " + list.get(0));
        System.out.println("last: " + list.get(list.size() - 1));
        assertEquals(200,list.size());
    }

    private void save1000Ticks() {
        for (int i = 0; i < 1000; i++) {

            UpbitTick upbitTick = UpbitTick.builder()
                    .sequentialId(Long.valueOf(i))
                    .code(UpbitCoinCode.KRW_ADA.toString())
                    .timestamp(Long.valueOf(i))
                    .build();


            UpbitTickRepository repo =
                    upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);

            repo.save(UpbitTickFactory.of(upbitTick));
        }
    }

}