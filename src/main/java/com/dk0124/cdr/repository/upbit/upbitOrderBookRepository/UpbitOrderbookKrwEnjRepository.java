package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEnjRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwEnj,Long> {
}
