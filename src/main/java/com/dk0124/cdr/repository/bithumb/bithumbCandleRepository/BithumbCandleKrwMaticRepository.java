package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwMaticRepository extends JpaRepository<BithumbCandleKrwMatic,Long>,BithumbCandleCommonJpaInterface {
}
