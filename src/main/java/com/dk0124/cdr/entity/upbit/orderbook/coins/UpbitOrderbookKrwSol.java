package com.dk0124.cdr.entity.upbit.orderbook.coins;


import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "upbit_orderbook_krw_sol", indexes = {
        @Index(name = "upbit_orderbook_krw_sol_index",  columnList="timestamp",unique = false)
})
public class UpbitOrderbookKrwSol extends UpbitOrderbook {
}
