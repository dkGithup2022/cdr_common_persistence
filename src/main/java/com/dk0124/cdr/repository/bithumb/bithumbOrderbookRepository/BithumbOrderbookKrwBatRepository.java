package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwBatRepository extends JpaRepository<BithumbOrderbookKrwBat, Long>, BithumbOrderbookCommonJpaInterface {
}
