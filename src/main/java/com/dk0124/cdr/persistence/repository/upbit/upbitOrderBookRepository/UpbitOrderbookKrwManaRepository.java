package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwManaRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwMana,Long> {
}
