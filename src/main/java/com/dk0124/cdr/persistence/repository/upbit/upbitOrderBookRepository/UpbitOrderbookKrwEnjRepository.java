package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEnjRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwEnj,Long> {
}
