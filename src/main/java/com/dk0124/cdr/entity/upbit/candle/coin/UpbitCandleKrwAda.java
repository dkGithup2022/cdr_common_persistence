package com.dk0124.cdr.entity.upbit.candle.coin;


import com.dk0124.cdr.entity.upbit.candle.UpbitCandle;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_candle_krw_ada", indexes = {
        @Index(name = "upbit_candle_krw_ada_index",  columnList="timestamp",unique = false)
})
public class UpbitCandleKrwAda extends UpbitCandle {
}
