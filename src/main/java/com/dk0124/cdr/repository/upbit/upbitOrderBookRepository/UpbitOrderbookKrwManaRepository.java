package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwManaRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwMana,Long> {
}
