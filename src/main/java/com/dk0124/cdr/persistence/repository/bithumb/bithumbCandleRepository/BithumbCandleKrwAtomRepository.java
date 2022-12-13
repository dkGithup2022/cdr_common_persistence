package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAtomRepository extends JpaRepository<BithumbCandleKrwAtom,Long>, BithumbCandleRepository {
}
