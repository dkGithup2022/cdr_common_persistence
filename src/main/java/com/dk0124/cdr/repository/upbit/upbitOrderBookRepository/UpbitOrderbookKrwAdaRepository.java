package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAdaRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAda,Long> {
}
