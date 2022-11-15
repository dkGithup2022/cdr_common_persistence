package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAxsRepository extends JpaRepository<BithumbOrderbookKrwAxs, Long>, BithumbOrderbookCommonJpaInterface {
}
