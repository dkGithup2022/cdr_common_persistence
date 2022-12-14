package com.dk0124.cdr.repositoryUtils.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository.UpbitCandleRepository;
import com.dk0124.cdr.persistence.repositoryUtils.upbit.UpbitCandleRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@IntegrationWithContainer
@Transactional
class UpbitCandleRepositoryUtilsTest {

    @Autowired
    UpbitCandleRepositoryUtils upbitCandleRepositoryUtils;

    @Test
    public void empty(){assertNotNull(upbitCandleRepositoryUtils);}

    @ParameterizedTest()
    @DisplayName("UpbitCandleRepositoryUtils.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_all_upbit_codes")
    public void get_repository_from_code(UpbitCoinCode code){
        UpbitCandleRepository repo = upbitCandleRepositoryUtils.getRepositoryFromCode(code);
        assertNotNull(repo);
    }

    @ParameterizedTest()
    @DisplayName("UpbitCandleRepositoryUtils.getRepositoryFromCode(String code) 테스트")
    @MethodSource("get_all_upbit_codes")
    public void get_repository_from_code_string(UpbitCoinCode code){
        UpbitCandleRepository repo = upbitCandleRepositoryUtils.getRepositoryFromCode(code.toString());
        assertNotNull(repo);
    }

    static Stream<Arguments> get_all_upbit_codes() {
        return Arrays.stream(UpbitCoinCode.values()).map(c -> Arguments.of(c));
    }

    /*
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    UpbitCandleRepositoryUtils upbitTickRepositoryPicker;

    @Test
    void empty() {
        assertNotNull(upbitTickRepositoryPicker);
    }


    @ParameterizedTest()
    @DisplayName("UpbitCandleRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_candles")
    void get_repository_from_code_code(UpbitCandle c) {
        UpbitCandleRepository repository = upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.fromString(c.getMarket()));
        UpbitCandle saved = repository.save(c);
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }

    @ParameterizedTest()
    @DisplayName("UpbitCandleRepositoryPicker.getRepositoryFromCode(String code) 테스트")
    @MethodSource("get_each_typed_upbit_candles")
    void get_repository_from_code_string(UpbitCandle c) {
        UpbitCandleRepository repository = upbitTickRepositoryPicker.getRepositoryFromCode(c.getMarket());
        UpbitCandle saved = repository.save(c);
        assertNotNull(saved);
        assertEquals(c.getClass(), saved.getClass());
    }


    static Stream<Arguments> get_each_typed_upbit_candles() {
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitCandle[] candles = new UpbitCandle[codes.length];
        for (int i = 0; i < candles.length; i++) {
            UpbitCandle c = UpbitCandle.builder()
                    .market(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            candles[i] = UpbitCandleUtils.of(c);
        }
        return Arrays.stream(candles).map(c -> Arguments.of(c));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    @Disabled
    void test_query_creation_less_than_timestamp() {
        save1000Candles();

        UpbitCandleRepository repo =
                upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        Page<UpbitCandle> list = repo.findByTimestampLessThanEqual(500L, pageRequest);


        assertEquals(200, list.getContent().size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 100 개 요청 성공 ")
    @Disabled
    void functionCreationWithPagable2() {
        save1000Candles();

        UpbitCandleRepository repo =
                upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        Page<UpbitCandle> list = repo.findByTimestampLessThanEqual(100L, pageRequest);


        System.out.println(list);
        assertEquals(101, list.getContent().size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / -1 개 요청 성공 ")
    @Disabled
    void functionCreationWithPagable3() {
        save1000Candles();

        UpbitCandleRepository repo =
                upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        Page<UpbitCandle> list = repo.findByTimestampLessThanEqual(-1L, pageRequest);


        System.out.println(list);
        System.out.println(list.getContent().size());
        assertEquals(0, list.getContent().size());
    }


    private void save1000Candles() {
        for (int i = 0; i < 1000; i++) {

            UpbitCandle candle = UpbitCandle
                    .builder()
                    .timestamp(Long.valueOf(i))
                    .market(UpbitCoinCode.KRW_ADA.toString())
                    .build();
            UpbitCandleRepository repo =
                    upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);
            repo.save(UpbitCandleUtils.of(candle));
        }
    }
    */

}