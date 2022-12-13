package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwDotRepository extends JpaRepository<BithumbOrderbookKrwDot, Long>, BithumbOrderbookRepository {
}
