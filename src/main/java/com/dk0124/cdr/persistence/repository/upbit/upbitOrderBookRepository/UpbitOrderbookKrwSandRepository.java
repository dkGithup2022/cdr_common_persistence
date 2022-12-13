package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSandRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwSand,Long> {
}
