package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwEthRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwEth,Long> {
}
