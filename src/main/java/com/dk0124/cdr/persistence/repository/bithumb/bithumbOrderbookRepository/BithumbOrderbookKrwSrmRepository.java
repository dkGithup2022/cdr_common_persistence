package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwSrmRepository extends JpaRepository<BithumbOrderbookKrwSrm, Long>, BithumbOrderbookCommonJpaInterface {
}
