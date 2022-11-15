package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwBchRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwBch,Long> {
}
