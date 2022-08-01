package com.dk0124.cdr.entity.upbit.tick;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UpbitTickFactoryTest {
    @Test
    void empty(){ }

    @ParameterizedTest()
    @DisplayName("UpbitTickFactory.of(abstract tick) 객체 생성 결과 확인하기  ")
    @MethodSource("get_each_upbit_ticks")
    void update_event_dto_to_event(UpbitTick tick){
        UpbitTick realTick = UpbitTickFactory.of(tick);

        String realTickClassName = realTick.getClass().toString();
        String inputCode = tick.getCode();

        assertEquals(realTickClassName.substring(realTickClassName.length()-3,realTickClassName.length()).toLowerCase(),
                inputCode.substring(inputCode.length()-3,inputCode.length()).toLowerCase()
                );
    }

    static Stream<Arguments> get_each_upbit_ticks(){
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        UpbitTick[] ticks = new UpbitTick[codes.length];
        for( int i = 0; i< ticks.length; i++ ) {
            UpbitTick t = UpbitTick.builder().code(codes[i].toString()).sequentialId(Long.valueOf(i)).build();
            ticks[i] = t;
        }
        return Arrays.stream(ticks).map(t->Arguments.of(t));
    }
}