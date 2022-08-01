package com.dk0124.cdr.entity.bithumb.orderbook.coins;


import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_orderbook_krw_btg",indexes = {
        @Index(name = "bithumb_orderbook_krw_btg_index",  columnList="datetime",unique = false)
})
public class BithumbOrderbookKrwBtg extends BithumbOrderbook {
}
