package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwBchRepository extends JpaRepository<BithumbOrderbookKrwBch, Long>, BithumbOrderbookRepository {
}
