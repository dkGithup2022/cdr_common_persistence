package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAvaxRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAvax,Long> {
}
