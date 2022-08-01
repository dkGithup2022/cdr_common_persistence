package com.dk0124.cdr.entity.bithumb.candle.coins;

import com.dk0124.cdr.entity.bithumb.candle.BithumbCandle;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_candle_krw_avax", indexes = {
        @Index(name = "bithumb_candle_krw_avax_index",  columnList="timestamp",unique = false)
})
public class BithumbCandleKrwAvax extends BithumbCandle {
}
