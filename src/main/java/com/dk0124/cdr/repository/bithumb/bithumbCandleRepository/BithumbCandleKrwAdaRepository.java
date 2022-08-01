package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAdaRepository extends BithumbCandleCommonJpaInterface, JpaRepository<BithumbCandleKrwAda,Long> {
}
