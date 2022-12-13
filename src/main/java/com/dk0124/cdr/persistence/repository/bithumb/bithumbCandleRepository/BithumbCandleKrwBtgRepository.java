package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwBtgRepository extends JpaRepository<BithumbCandleKrwBtg,Long>, BithumbCandleRepository {
}
