package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwSandRepository extends JpaRepository<BithumbCandleKrwSand,Long>,BithumbCandleCommonJpaInterface {
}
