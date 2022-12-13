package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAdaRepository extends BithumbCandleRepository, JpaRepository<BithumbCandleKrwAda,Long> {
}
