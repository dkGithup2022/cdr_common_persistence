package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAxsRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAxs,Long> {
}
