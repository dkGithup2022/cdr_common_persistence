package com.dk0124.cdr.repositoryUtils.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.orderbook.BithumbOrderbookDto;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbook;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbookUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbOrderbookMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository.BithumbOrderbookCommonJpaInterface;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbOrderbookRepositoryUtils;
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
class BithumbOrderbookRepositoryUtilsTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbOrderbookRepositoryUtils bithumbOrderbookRepositoryUtils;

    @Autowired
    BithumbOrderbookMapper bithumbOrderbookMapper;

    @Test
    void empty(){ assertNotNull(bithumbOrderbookRepositoryUtils);}

    @ParameterizedTest()
    @DisplayName("BithumbOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_bithumb_orderbooks")
    void getRepositoryFromCode(BithumbOrderbook o){
        BithumbOrderbookCommonJpaInterface repository = bithumbOrderbookRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.fromString(o.getCode()));
        BithumbOrderbook saved = repository.save(o);
        assertNotNull(saved);
        assertEquals(o.getClass(),saved.getClass());
    }



    static Stream<Arguments> get_each_bithumb_orderbooks(){
        BithumbCoinCode[] codes = BithumbCoinCode.values();
        BithumbOrderbook[] candles = new BithumbOrderbook[codes.length];
        for( int i =0 ;i<candles.length; i++){
            BithumbOrderbook o = BithumbOrderbook
                    .builder()
                    .code(codes[i].toString())
                    .datetime(Long.valueOf(i))
                    .build();
            candles[i] = BithumbOrderbookUtils.of(o);
        }
        return Arrays.stream(candles).map(o->Arguments.of(o));
    }



    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void functionCreationWithPagable() {
        save1000Orderbooks();

        BithumbOrderbookCommonJpaInterface repo
                = bithumbOrderbookRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("datetime").descending());
        List<BithumbOrderbook> list = repo.findByDatetimeLessThanEqual(500L, pageRequest).getContent();


        System.out.println(list);
        System.out.println(list.size());
        System.out.println("first: " + list.get(0));
        System.out.println("last: " + list.get(list.size() - 1));
        assertEquals(200,list.size());
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, 100 번째 순서에 ")
    void functionCreationWithPagabl2() {
        save1000Orderbooks();

        BithumbOrderbookCommonJpaInterface repo
                = bithumbOrderbookRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("datetime").descending());
        List<BithumbOrderbook> list = repo.findByDatetimeLessThanEqual(100L, pageRequest).getContent();


        System.out.println(list);
        System.out.println(list.size());
        System.out.println("first: " + list.get(0));
        System.out.println("last: " + list.get(list.size() - 1));
        assertEquals(101,list.size());

    }


    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청, -1 번째 순서에 ")
    void functionCreationWithPagabl3() {
        save1000Orderbooks();

        BithumbOrderbookCommonJpaInterface repo
                = bithumbOrderbookRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.KRW_ADA);

        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("datetime").descending());
        List<BithumbOrderbook> list = repo.findByDatetimeLessThanEqual(-1L, pageRequest).getContent();

        assertEquals(0,list.size());

    }



    private void save1000Orderbooks() {
        for (int i = 0; i < 1000; i++) {
            BithumbOrderbookDto dto = BithumbOrderbookDto
                    .builder()
                    .code(BithumbCoinCode.KRW_ADA.toString())
                    .datetime(Long.valueOf(i))
                    .build();

            BithumbOrderbookCommonJpaInterface repo =
                    bithumbOrderbookRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.fromString(dto.getCode()));
            repo.save(BithumbOrderbookUtils.of(bithumbOrderbookMapper.mapOrderbook(dto)));
        }
    }


}