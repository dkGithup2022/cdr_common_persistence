package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwBatRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwBat,Long> {
}
