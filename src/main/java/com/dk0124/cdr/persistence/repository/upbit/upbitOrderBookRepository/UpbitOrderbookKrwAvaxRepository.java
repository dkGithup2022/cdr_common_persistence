package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAvaxRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwAvax,Long> {
}
