package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwEthRepository extends JpaRepository<BithumbOrderbookKrwEth, Long>, BithumbOrderbookRepository {
}
