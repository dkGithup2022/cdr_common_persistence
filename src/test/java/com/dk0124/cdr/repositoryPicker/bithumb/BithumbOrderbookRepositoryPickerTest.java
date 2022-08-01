package com.dk0124.cdr.repositoryPicker.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.entity.bithumb.candle.BithumbCandleFactory;
import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbook;
import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbookFactory;
import com.dk0124.cdr.repository.bithumb.bithumbCandleRepository.BithumbCandleCommonJpaInterface;
import com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository.BithumbOrderbookCommonJpaInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
@Testcontainers
class BithumbOrderbookRepositoryPickerTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbOrderbookRepositoryPicker bithumbOrderbookRepositoryPicker;

    @Test
    void empty(){ assertNotNull(bithumbOrderbookRepositoryPicker);}

    @ParameterizedTest()
    @DisplayName("BithumbOrderbookRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_bithumb_orderbooks")
    void getRepositoryFromCode(BithumbOrderbook o){
        BithumbOrderbookCommonJpaInterface repository = bithumbOrderbookRepositoryPicker.getRepositoryFromCode(BithumbCoinCode.fromString(o.getCode()));
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
            candles[i] = BithumbOrderbookFactory.of(o);
        }
        return Arrays.stream(candles).map(o->Arguments.of(o));
    }


}