package com.dk0124.cdr.entity.upbit.candle.coin;


import com.dk0124.cdr.entity.upbit.candle.UpbitCandle;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_candle_krw_stx",indexes = {
        @Index(name = "upbit_candle_krw_stx_index",  columnList="timestamp",unique = false)
})
public class UpbitCandleKrwStx  extends UpbitCandle {
}
