package com.dk0124.cdr.data;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.tick.BithumbTickDto;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTick;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertNotNull;

public class BithumbTickMappingTest {

    @Test
    @DisplayName("data: BithumbTickDto.timestamp 자동생성 확인 ")
    public void generate_timestamp_bithumb_dto_tick() {
        BithumbTickDto dto1 = BithumbTickDto.builder().contDtm(new Date()).build();
        BithumbTickDto dto2 = new BithumbTickDto();
        dto2.setContDtm(new Date());

        assertNotNull(dto1.getTimestamp());
        assertNotNull(dto2.getTimestamp());
    }

    @Test
    @DisplayName("data: BithumbTick.timestamp 자동생성 확인 ")
    public void generate_timestamp_bithumb_tick() {
        BithumbTick tick1 = BithumbTick.builder().contDtm(new Date()).build();

        BithumbTick tick2 = new BithumbTick();
        tick2.setContDtm(new Date());

        assertNotNull(tick1.getTimestamp());
        assertNotNull(tick2.getTimestamp());
    }

    @Test
    public void printCode(){
        UpbitCoinCode[] codes = UpbitCoinCode.values();
        String[] list = Arrays.stream(codes)
                .map(c->c.toString()).toArray(String[]::new );

        System.out.println(Arrays.toString(list));


        BithumbCoinCode[] codes2 = BithumbCoinCode.values();
        String[] list2 = Arrays.stream(codes2)
                .map(c->c.toString()).toArray(String[]::new);

        System.out.println(Arrays.toString(list2));
    }

}
