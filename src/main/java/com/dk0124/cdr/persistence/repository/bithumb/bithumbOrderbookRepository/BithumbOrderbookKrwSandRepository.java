package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwSandRepository extends JpaRepository<BithumbOrderbookKrwSand, Long>, BithumbOrderbookCommonJpaInterface {
}
