package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwPlaRepository extends JpaRepository<UpbitCandleKrwPla, Long>, UpbitCandleRepository {
}
