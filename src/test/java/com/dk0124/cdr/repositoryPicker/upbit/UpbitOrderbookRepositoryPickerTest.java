package com.dk0124.cdr.repositoryPicker.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.entity.bithumb.tick.BithumbTick;
import com.dk0124.cdr.entity.bithumb.tick.BithumbTickFactory;
import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderBookFactory;
import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderbook;
import com.dk0124.cdr.repository.bithumb.bithumbTickRepository.BithumbTickCommonJpaInterface;
import com.dk0124.cdr.repository.upbit.upbitOrderBookRepository.UpbitOrderbookCommonRepository;
import com.dk0124.cdr.repository.upbit.upbitOrderBookRepository.UpbitOrderbookKrwAdaRepository;
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
class UpbitOrderbookRepositoryPickerTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");
    @Autowired
    UpbitOrderbookRepositoryPicker upbitOrderbookRepositoryPicker;
    @Autowired
    UpbitOrderbookKrwAdaRepository upbitOrderbookKrwAdaRepository;

    @Test
    void empty(){
        assertNotNull(upbitOrderbookRepositoryPicker);
    }

    @ParameterizedTest()
    @DisplayName("UpbitOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_orderbook")
    void get_repository_from_code(UpbitOrderbook book){
        UpbitOrderbookCommonRepository repository = upbitOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.fromString(book.getCode()));
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
            books[i] = UpbitOrderBookFactory.of(o);
        }
        return  Arrays.stream(books).map(o->Arguments.of(o));
    }

    @Test
    @DisplayName("기능 테스트, timestamp 기준 creation query 테스트 / 200 개 요청 성공 ")
    void functionCreationWithPagable() {
        save1000Orderbooks();


        UpbitOrderbookCommonRepository repo
                = upbitOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);


        PageRequest pageRequest = PageRequest.of(0, 200, Sort.by("timestamp").descending());
        List<UpbitOrderbook> list = repo.findByTimestampLessThanEqual(500L, pageRequest);


        System.out.println(list);
        System.out.println(list.size());
        System.out.println("first: " + list.get(0));
        System.out.println("last: " + list.get(list.size() - 1));
        assertEquals(200,list.size());
    }



    private void save1000Orderbooks() {
        for (int i = 0; i < 1000; i++) {
            UpbitOrderbook upbitOrderbook =
                    UpbitOrderbook.builder()
                            .timestamp(Long.valueOf(i))
                            .code(UpbitCoinCode.KRW_ADA.toString())
                            .build();
            UpbitOrderbookCommonRepository repo
                    = upbitOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.KRW_ADA);

            repo.save(UpbitOrderBookFactory.of(upbitOrderbook));

        }
    }



}