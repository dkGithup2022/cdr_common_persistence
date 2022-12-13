package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwMaticRepository extends JpaRepository<BithumbOrderbookKrwMatic, Long>, BithumbOrderbookRepository {
}
