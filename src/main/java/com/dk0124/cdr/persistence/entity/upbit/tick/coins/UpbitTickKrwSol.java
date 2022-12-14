package com.dk0124.cdr.persistence.entity.upbit.tick.coins;


import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="upbit_tick_krw_sol", indexes = {
        @Index(name = "upbit_tick_krw_sol_index",  columnList="timestamp",unique = false)
})
public class UpbitTickKrwSol extends UpbitTick implements Serializable {
}
