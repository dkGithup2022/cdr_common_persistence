package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSrmRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwSrm,Long> {
}
