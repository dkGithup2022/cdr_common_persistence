package com.dk0124.cdr.entity.upbit.tick.coins;

import com.dk0124.cdr.entity.upbit.tick.UpbitTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "upbit_tick_krw_eth", indexes = {
        @Index(name = "upbit_tick_krw_eth_index",  columnList="timestamp",unique = false)
})
public class UpbitTickKrwEth extends UpbitTick implements Serializable {
}
