package com.dk0124.cdr.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBchRepository extends JpaRepository<UpbitCandleKrwBch, Long>, UpbitCandleCommonJpaInterface {
}
