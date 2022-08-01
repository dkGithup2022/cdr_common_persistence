package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwDogeRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwDoge,Long> {
}
