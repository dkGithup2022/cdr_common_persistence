package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwDotRepository extends JpaRepository<BithumbCandleKrwDot,Long>,BithumbCandleCommonJpaInterface {
}
