package com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins;


import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbook;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_orderbook_krw_mana",indexes = {
        @Index(name = "bithumb_orderbook_krw_mana_index",  columnList="datetime",unique = false)
})
public class BithumbOrderbookKrwMana extends BithumbOrderbook {
}
