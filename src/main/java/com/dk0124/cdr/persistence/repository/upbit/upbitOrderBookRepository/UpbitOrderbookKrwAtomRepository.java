package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.coins.UpbitOrderbookKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAtomRepository extends UpbitOrderbookRepository, JpaRepository<UpbitOrderbookKrwAtom,Long> {
}
