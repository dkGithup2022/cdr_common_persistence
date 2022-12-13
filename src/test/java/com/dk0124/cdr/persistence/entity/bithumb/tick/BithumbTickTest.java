package com.dk0124.cdr.persistence.entity.bithumb.tick;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BithumbTickTest {
    @Test
    public void empty(){};

    @Test
    public void builder_check_timestamp(){
        //given when
        BithumbTick t = BithumbTick.builder()
                .contDtm(new Date()).build();

        //then
        assertNotNull(t.getTimestamp());

    }

    @Test
    public void setter_check_timestamp(){
        //given when
        BithumbTick t=  new BithumbTick();
        t.setContDtm(new Date());


        //then
        assertNotNull(t.getTimestamp());
    }


}