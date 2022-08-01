package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwXrpRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwXrp,Long> {
}
