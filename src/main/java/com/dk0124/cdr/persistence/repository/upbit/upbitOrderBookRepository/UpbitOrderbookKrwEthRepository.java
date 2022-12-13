package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEthRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwEth,Long> {
}
