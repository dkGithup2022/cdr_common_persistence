package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwSrmRepository extends JpaRepository<BithumbCandleKrwSrm,Long>,BithumbCandleCommonJpaInterface {
}
