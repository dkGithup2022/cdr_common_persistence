package com.dk0124.cdr.entity.bithumb.tick.coins;

import com.dk0124.cdr.entity.bithumb.tick.BithumbTick;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "bithumb_tick_krw_axs", indexes = {
        @Index(name = "bithumb_tick_krw_axs_index",  columnList="timestamp",unique = false)
})
public class BithumbTickKrwAxs extends BithumbTick {
}
