package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwEthRepository extends JpaRepository<BithumbOrderbookKrwEth, Long>, BithumbOrderbookCommonJpaInterface {
}
