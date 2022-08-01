package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwBtgRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBtg,Long> {
}
