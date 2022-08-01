package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwStx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwStxRepository extends JpaRepository<UpbitCandleKrwStx, Long>, UpbitCandleCommonJpaInterface {
}
