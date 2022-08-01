package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwEtcRepository extends JpaRepository<UpbitCandleKrwEtc, Long>, UpbitCandleCommonJpaInterface {
}
