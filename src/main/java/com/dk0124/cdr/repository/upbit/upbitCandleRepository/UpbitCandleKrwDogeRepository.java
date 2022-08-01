package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwDogeRepository extends JpaRepository<UpbitCandleKrwDoge, Long>, UpbitCandleCommonJpaInterface {
}
