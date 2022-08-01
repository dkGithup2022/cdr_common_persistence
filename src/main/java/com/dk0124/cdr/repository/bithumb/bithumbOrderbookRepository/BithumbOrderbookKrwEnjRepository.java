package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwEnjRepository extends JpaRepository<BithumbOrderbookKrwEnj, Long>, BithumbOrderbookCommonJpaInterface {
}
