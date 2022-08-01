package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwChzRepository extends JpaRepository<BithumbCandleKrwChz,Long>,BithumbCandleCommonJpaInterface {
}
