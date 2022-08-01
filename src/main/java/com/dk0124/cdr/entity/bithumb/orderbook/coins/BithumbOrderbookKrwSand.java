package com.dk0124.cdr.entity.bithumb.orderbook.coins;


import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_orderbook_krw_sand",indexes = {
        @Index(name = "bithumb_orderbook_krw_sand_index",  columnList="datetime",unique = false)
})
public class BithumbOrderbookKrwSand extends BithumbOrderbook {
}
