package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwXrpRepository extends JpaRepository<BithumbOrderbookKrwXrp, Long>, BithumbOrderbookRepository {
}
