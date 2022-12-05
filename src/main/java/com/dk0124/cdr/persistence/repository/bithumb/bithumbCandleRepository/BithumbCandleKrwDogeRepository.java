package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwDogeRepository extends JpaRepository<BithumbCandleKrwDoge,Long>,BithumbCandleCommonJpaInterface {
}
