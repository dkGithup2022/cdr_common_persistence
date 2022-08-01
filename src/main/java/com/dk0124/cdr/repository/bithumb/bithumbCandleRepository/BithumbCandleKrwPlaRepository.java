package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwPlaRepository extends JpaRepository<BithumbCandleKrwPla,Long>,BithumbCandleCommonJpaInterface {
}
