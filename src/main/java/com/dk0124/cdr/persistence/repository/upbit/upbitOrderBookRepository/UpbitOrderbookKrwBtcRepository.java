package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UpbitOrderbookKrwBtcRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBtc,Long> {
}
