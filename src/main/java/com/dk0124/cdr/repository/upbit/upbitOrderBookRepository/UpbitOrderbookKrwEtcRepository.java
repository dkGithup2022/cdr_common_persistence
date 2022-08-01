package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEtcRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwEtc,Long> {
}
