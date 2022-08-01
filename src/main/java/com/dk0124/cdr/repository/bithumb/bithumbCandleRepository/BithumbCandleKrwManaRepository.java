package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.coins.BithumbCandleKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwManaRepository extends JpaRepository<BithumbCandleKrwMana,Long>,BithumbCandleCommonJpaInterface {
}
