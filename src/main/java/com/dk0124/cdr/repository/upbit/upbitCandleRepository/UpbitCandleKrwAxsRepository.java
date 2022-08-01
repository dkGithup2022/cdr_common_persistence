package com.dk0124.cdr.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAxsRepository extends JpaRepository<UpbitCandleKrwAxs, Long>, UpbitCandleCommonJpaInterface {
}
