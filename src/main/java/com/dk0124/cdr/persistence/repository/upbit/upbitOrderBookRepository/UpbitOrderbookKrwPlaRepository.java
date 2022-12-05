package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwPlaRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwPla,Long> {
}
