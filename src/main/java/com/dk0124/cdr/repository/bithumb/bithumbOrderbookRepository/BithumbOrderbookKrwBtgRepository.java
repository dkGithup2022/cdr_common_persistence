package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwBtgRepository extends JpaRepository<BithumbOrderbookKrwBtg, Long>, BithumbOrderbookCommonJpaInterface {
}
