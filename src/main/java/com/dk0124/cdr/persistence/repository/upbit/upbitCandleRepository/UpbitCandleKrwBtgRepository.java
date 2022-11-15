package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBtgRepository extends JpaRepository<UpbitCandleKrwBtg, Long>, UpbitCandleCommonJpaInterface {
}
