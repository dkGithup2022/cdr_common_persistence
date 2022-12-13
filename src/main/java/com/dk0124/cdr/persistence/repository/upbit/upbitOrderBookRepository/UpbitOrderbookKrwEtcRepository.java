package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEtcRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwEtc,Long> {
}
