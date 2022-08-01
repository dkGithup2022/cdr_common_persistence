package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwEtcRepository extends JpaRepository<BithumbCandleKrwEtc,Long>,BithumbCandleCommonJpaInterface {
}
