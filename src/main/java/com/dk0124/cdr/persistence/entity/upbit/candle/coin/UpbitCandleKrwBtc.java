package com.dk0124.cdr.persistence.entity.upbit.candle.coin;

import com.dk0124.cdr.persistence.entity.upbit.candle.UpbitCandle;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_candle_krw_btc",indexes = {
        @Index(name = "upbit_candle_krw_btc_index",  columnList="timestamp",unique = false)
})
public class UpbitCandleKrwBtc extends UpbitCandle {
}
