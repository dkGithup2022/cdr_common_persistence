package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwXrpRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwXrp,Long> {
}
