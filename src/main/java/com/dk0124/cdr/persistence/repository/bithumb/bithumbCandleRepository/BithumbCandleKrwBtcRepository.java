package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBtcRepository extends JpaRepository<BithumbCandleKrwBtc,Long>, BithumbCandleRepository {
}
