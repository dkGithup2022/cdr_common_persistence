package com.dk0124.cdr.persistence.entity.upbit.orderbook.coins;


import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_orderbook_krw_pla", indexes = {
        @Index(name = "upbit_orderbook_krw_pla_index",  columnList="timestamp",unique = false)
})
public class UpbitOrderbookKrwPla extends UpbitOrderbook {
}
