package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwStx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwStxRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwStx,Long> {
}
