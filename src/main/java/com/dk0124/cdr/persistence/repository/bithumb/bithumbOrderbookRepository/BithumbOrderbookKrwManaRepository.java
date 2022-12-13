package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwManaRepository extends JpaRepository<BithumbOrderbookKrwMana, Long>, BithumbOrderbookRepository {
}
