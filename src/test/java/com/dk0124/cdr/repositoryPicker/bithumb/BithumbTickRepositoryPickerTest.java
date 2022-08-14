package com.dk0124.cdr.repositoryPicker.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.entity.bithumb.tick.BithumbTick;
import com.dk0124.cdr.entity.bithumb.tick.BithumbTickFactory;
import com.dk0124.cdr.repository.bithumb.bithumbTickRepository.BithumbTickCommonJpaInterface;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@IntegrationWithContainer
class BithumbTickRepositoryPickerTest {

    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbTickRepositoryPicker bithumbTickRepositoryPicker;

    @Test
    void empty(){assertNotNull(bithumbTickRepositoryPicker);}

    @ParameterizedTest()
    @DisplayName("BithumbTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_candles")
    void getRepositoryFromCode(BithumbTick t){
       BithumbTickCommonJpaInterface repository = bithumbTickRepositoryPicker.getRepositoryFromCode(BithumbCoinCode.fromString(t.getCode()));
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
                    .timestamp(Long.valueOf(i))
                    .build();
            ticks[i] = BithumbTickFactory.of(c);
        }
        return Arrays.stream(ticks).map(t->Arguments.of(t));
    }

}