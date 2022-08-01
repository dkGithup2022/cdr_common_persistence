package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwDogeRepository extends JpaRepository<BithumbOrderbookKrwDoge, Long>, BithumbOrderbookCommonJpaInterface {
}
