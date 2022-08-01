package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwPlaRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwPla,Long> {
}
