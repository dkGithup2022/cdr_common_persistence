package com.dk0124.cdr.persistence.entity.upbit.tick.coins;

import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "upbit_tick_krw_pla", indexes = {
        @Index(name = "upbit_tick_krw_pla_index",  columnList="timestamp",unique = false)
})
public class UpbitTickKrwPla extends UpbitTick implements Serializable {
}
