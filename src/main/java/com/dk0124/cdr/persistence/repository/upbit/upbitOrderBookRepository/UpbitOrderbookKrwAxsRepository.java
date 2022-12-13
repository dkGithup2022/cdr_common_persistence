package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAxsRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwAxs,Long> {
}
