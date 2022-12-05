package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBchRepository extends JpaRepository<BithumbCandleKrwBch,Long>,BithumbCandleCommonJpaInterface {
}
