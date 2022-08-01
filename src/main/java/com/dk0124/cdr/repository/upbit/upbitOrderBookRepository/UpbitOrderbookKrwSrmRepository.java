package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSrmRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwSrm,Long> {
}
