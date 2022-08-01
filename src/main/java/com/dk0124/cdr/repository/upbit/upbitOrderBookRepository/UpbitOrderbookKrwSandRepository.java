package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSandRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwSand,Long> {
}
