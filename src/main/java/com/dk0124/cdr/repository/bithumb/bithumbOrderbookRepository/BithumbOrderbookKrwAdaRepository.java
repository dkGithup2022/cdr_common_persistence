package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAdaRepository extends JpaRepository<BithumbOrderbookKrwAda, Long>, BithumbOrderbookCommonJpaInterface {
}
