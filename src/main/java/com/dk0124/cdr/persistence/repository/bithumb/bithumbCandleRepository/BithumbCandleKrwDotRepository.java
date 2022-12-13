package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwDotRepository extends JpaRepository<BithumbCandleKrwDot,Long>, BithumbCandleRepository {
}
