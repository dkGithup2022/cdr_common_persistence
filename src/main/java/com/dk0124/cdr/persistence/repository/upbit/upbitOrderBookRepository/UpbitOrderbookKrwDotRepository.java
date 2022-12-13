package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwDotRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwDot,Long> {
}
