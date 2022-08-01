package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwChzRepository extends JpaRepository<UpbitCandleKrwChz, Long>, UpbitCandleCommonJpaInterface {
}
