package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwEthRepository extends JpaRepository<BithumbCandleKrwEth,Long>,BithumbCandleCommonJpaInterface {
}
