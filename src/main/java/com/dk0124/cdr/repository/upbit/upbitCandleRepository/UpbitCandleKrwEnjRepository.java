package com.dk0124.cdr.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwEnjRepository extends JpaRepository<UpbitCandleKrwEnj, Long>, UpbitCandleCommonJpaInterface {
}
