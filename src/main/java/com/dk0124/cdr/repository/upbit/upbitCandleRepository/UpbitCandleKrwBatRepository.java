package com.dk0124.cdr.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBatRepository extends JpaRepository<UpbitCandleKrwBat, Long>, UpbitCandleCommonJpaInterface {
}
