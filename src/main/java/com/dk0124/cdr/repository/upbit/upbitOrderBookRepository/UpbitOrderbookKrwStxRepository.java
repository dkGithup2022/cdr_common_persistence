package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwStx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwStxRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwStx,Long> {
}
