package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwSandRepository extends JpaRepository<UpbitCandleKrwSand, Long>, UpbitCandleCommonJpaInterface {
}
