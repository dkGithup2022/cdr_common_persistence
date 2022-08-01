package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwPlaRepository extends JpaRepository<UpbitCandleKrwPla, Long>, UpbitCandleCommonJpaInterface {
}
