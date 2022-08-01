package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwFlowRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwFlow,Long> {
}
