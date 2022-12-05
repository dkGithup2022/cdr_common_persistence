package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwStx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwStxRepository extends JpaRepository<UpbitCandleKrwStx, Long>, UpbitCandleCommonJpaInterface {
}
