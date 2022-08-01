package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwMaticRepository extends JpaRepository<BithumbOrderbookKrwMatic, Long>, BithumbOrderbookCommonJpaInterface {
}
