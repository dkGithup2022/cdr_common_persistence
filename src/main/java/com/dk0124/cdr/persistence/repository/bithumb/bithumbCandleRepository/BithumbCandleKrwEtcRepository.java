package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwEtcRepository extends JpaRepository<BithumbCandleKrwEtc,Long>, BithumbCandleRepository {
}
