package com.dk0124.cdr.data;

import com.dk0124.cdr.persistence.dto.bithumb.tick.BithumbTickDto;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTick;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

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


}
