package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSolRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwSol,Long> {
}
