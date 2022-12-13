package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwSolRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwSol,Long> {
}
