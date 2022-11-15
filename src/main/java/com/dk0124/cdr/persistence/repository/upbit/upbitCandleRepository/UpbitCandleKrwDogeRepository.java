package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwDogeRepository extends JpaRepository<UpbitCandleKrwDoge, Long>, UpbitCandleCommonJpaInterface {
}
