package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBatRepository extends JpaRepository<UpbitCandleKrwBat, Long>, UpbitCandleCommonJpaInterface {
}
