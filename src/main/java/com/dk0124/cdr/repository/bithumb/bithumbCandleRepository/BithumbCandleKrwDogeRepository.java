package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwDogeRepository extends JpaRepository<BithumbCandleKrwDoge,Long>,BithumbCandleCommonJpaInterface {
}
