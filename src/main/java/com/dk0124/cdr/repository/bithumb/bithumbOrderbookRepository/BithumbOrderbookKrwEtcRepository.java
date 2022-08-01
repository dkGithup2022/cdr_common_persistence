package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwEtcRepository extends JpaRepository<BithumbOrderbookKrwEtc, Long>, BithumbOrderbookCommonJpaInterface {
}
