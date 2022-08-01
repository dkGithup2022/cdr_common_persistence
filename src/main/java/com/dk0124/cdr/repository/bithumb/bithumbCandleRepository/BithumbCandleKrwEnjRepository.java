package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwEnjRepository extends JpaRepository<BithumbCandleKrwEnj,Long>,BithumbCandleCommonJpaInterface {
}
