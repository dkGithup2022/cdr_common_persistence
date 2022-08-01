package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwSolRepository extends JpaRepository<BithumbOrderbookKrwSol, Long>, BithumbOrderbookCommonJpaInterface {
}
