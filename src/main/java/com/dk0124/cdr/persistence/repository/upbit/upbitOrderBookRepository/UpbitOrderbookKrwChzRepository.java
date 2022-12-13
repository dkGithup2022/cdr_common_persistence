package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwChzRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwChz,Long> {
}
