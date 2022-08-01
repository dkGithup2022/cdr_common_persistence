package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;

import com.dk0124.cdr.entity.upbit.orderbook.coins.UpbitOrderbookKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitOrderbookKrwAtomRepository extends UpbitOrderbookCommonRepository, JpaRepository<UpbitOrderbookKrwAtom,Long> {
}
