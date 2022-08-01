package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwMaticRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwMatic,Long> {
}
