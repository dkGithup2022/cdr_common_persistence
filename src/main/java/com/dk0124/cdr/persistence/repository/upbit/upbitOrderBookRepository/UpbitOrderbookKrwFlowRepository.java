package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwFlowRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwFlow,Long> {
}
