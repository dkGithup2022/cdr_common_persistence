package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwDotRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwDot,Long> {
}
