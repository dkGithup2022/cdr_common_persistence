package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBatRepository extends JpaRepository<BithumbCandleKrwBat,Long>, BithumbCandleRepository {
}
