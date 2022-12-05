package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwPlaRepository extends JpaRepository<BithumbOrderbookKrwPla, Long>, BithumbOrderbookCommonJpaInterface {
}
