package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.coins.BithumbCandleKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbCandleKrwMaticRepository extends JpaRepository<BithumbCandleKrwMatic,Long>, BithumbCandleRepository {
}
