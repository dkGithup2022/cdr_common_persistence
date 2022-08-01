package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwSrmRepository extends JpaRepository<BithumbCandleKrwSrm,Long>,BithumbCandleCommonJpaInterface {
}
