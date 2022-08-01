package com.dk0124.cdr.entity.upbit.candle.coin;


import com.dk0124.cdr.entity.upbit.candle.UpbitCandle;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_candle_krw_srm",indexes = {
        @Index(name = "upbit_candle_krw_srm_index",  columnList="timestamp",unique = false)
})
public class UpbitCandleKrwSrm extends UpbitCandle {
}
