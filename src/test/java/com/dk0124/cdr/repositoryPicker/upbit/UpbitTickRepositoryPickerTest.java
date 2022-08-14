package com.dk0124.cdr.repositoryPicker.upbit;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.entity.upbit.tick.UpbitTick;
import com.dk0124.cdr.entity.upbit.tick.UpbitTickFactory;
import com.dk0124.cdr.repository.upbit.upbitTickRepository.UpbitTickRepository;
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
}