package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAdaRepository extends JpaRepository<BithumbOrderbookKrwAda, Long>, BithumbOrderbookRepository {
}
