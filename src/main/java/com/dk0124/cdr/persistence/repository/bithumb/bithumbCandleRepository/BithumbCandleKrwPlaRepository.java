package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwPlaRepository extends JpaRepository<BithumbCandleKrwPla,Long>,BithumbCandleCommonJpaInterface {
}
