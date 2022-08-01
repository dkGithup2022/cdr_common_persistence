package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAtomRepository extends JpaRepository<BithumbCandleKrwAtom,Long>,BithumbCandleCommonJpaInterface {
}
