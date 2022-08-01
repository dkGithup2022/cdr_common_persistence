package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBchRepository extends JpaRepository<BithumbCandleKrwBch,Long>,BithumbCandleCommonJpaInterface {
}
