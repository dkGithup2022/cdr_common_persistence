package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwXrpRepository extends JpaRepository<BithumbCandleKrwXrp,Long>, BithumbCandleRepository {
}
