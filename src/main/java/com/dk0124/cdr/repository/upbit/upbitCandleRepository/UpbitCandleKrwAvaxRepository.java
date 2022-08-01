package com.dk0124.cdr.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAvaxRepository extends JpaRepository<UpbitCandleKrwAvax, Long>, UpbitCandleCommonJpaInterface {
}
