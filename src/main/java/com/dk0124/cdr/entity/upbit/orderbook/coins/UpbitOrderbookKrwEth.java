package com.dk0124.cdr.entity.upbit.orderbook.coins;


import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_orderbook_krw_eth", indexes = {
        @Index(name = "upbit_orderbook_krw_eth_index",  columnList="timestamp",unique = false)
})
public class UpbitOrderbookKrwEth extends UpbitOrderbook {
}
