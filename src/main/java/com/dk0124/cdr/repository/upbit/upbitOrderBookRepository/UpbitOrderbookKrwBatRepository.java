package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwBatRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBat,Long> {
}
