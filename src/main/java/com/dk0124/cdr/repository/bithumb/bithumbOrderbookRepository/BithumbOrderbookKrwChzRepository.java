package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwChzRepository extends JpaRepository<BithumbOrderbookKrwChz, Long>, BithumbOrderbookCommonJpaInterface {
}
