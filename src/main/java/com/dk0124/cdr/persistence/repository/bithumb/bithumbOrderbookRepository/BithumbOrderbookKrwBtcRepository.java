package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwBtcRepository extends JpaRepository<BithumbOrderbookKrwBtc, Long>, BithumbOrderbookRepository {
}
