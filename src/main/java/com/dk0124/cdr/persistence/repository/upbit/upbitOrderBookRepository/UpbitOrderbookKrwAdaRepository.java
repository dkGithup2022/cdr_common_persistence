package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAdaRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwAda,Long> {
}
