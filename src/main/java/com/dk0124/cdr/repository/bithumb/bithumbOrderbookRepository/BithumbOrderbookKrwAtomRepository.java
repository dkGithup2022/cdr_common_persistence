package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.coins.BithumbOrderbookKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbOrderbookKrwAtomRepository extends JpaRepository<BithumbOrderbookKrwAtom, Long>, BithumbOrderbookCommonJpaInterface {
}
