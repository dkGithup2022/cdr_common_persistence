package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwAxsRepository extends JpaRepository<BithumbCandleKrwAxs,Long>, BithumbCandleRepository {
}
