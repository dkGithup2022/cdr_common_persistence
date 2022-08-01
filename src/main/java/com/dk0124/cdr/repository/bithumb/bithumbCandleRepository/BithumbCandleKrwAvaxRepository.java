package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAvaxRepository extends JpaRepository<BithumbCandleKrwAvax,Long>,BithumbCandleCommonJpaInterface {
}
