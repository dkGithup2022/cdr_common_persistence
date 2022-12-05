package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwSolRepository extends JpaRepository<BithumbCandleKrwSol,Long>,BithumbCandleCommonJpaInterface {
}
