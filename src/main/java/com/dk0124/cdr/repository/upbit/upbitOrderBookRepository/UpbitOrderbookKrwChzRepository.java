package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwChzRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwChz,Long> {
}
