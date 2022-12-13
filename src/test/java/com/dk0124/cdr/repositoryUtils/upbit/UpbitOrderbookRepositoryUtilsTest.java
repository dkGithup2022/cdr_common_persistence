package com.dk0124.cdr.repositoryUtils.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderBookUtils;
import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderbook;
import com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository.UpbitOrderbookRepository;
import com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository.UpbitOrderbookKrwAdaRepository;
import com.dk0124.cdr.persistence.repositoryUtils.upbit.UpbitOrderbookRepositoryUtils;
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
class UpbitOrderbookRepositoryUtilsTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");
    @Autowired
    UpbitOrderbookRepositoryUtils upbitOrderbookRepositoryUtils;
    @Autowired
    UpbitOrderbookKrwAdaRepository upbitOrderbookKrwAdaRepository;

    @Test
    void empty(){
        assertNotNull(upbitOrderbookRepositoryUtils);
    }

    @ParameterizedTest()
    @DisplayName("UpbitOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_orderbook")
    void get_repository_from_code(UpbitOrderbook book){
        UpbitOrderbookRepository repository = upbitOrderbookRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.fromString(book.getCode()));
        UpbitOrderbook saved = repository.save(book);
        assertNotNull(saved);
        assertEquals(book.getClass(),saved.getClass());
    }


    static Stream<Arguments> get_each_typed_upbit_orderbook(){
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitOrderbook[] books = new UpbitOrderbook[codes.length];
        for( int i =0 ; i< books.length; i++){
            UpbitOrderbook o = UpbitOrderbook
                    .builder()
                    .code(codes[i].toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            books[i] = UpbitOrderBookUtils.of(o);
        }
        return  Arrays.stream(books).map(o->Arguments.of(o));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void functionCreationWithPagable() {
        save1000Orderbooks();


        UpbitOrderbookRepository repo
                = upbitOrderbookRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        Page<UpbitOrderbook> list = repo.findByTimestampLessThanEqual(500L, pageRequest);



        assertEquals(200,list.getContent().size());
    }



    private void save1000Orderbooks() {
        for (int i = 0; i < 1000; i++) {
            UpbitOrderbook upbitOrderbook =
                    UpbitOrderbook.builder()
                            .timestamp(Long.valueOf(i))
                            .code(UpbitCoinCode.KRW_ADA.toString())
                            .build();
            UpbitOrderbookRepository repo
                    = upbitOrderbookRepositoryUtils.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);

            repo.save(UpbitOrderBookUtils.of(upbitOrderbook));

        }
    }



}