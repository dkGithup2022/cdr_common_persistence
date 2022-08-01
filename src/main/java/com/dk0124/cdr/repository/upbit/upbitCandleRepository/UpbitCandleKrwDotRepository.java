package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwDotRepository extends JpaRepository<UpbitCandleKrwDot, Long>, UpbitCandleCommonJpaInterface {
}
