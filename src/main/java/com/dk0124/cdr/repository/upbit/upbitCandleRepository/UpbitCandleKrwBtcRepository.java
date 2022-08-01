package com.dk0124.cdr.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBtcRepository extends JpaRepository<UpbitCandleKrwBtc, Long>, UpbitCandleCommonJpaInterface {
}
