package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAvaxRepository extends JpaRepository<BithumbOrderbookKrwAvax, Long>, BithumbOrderbookCommonJpaInterface {
}
