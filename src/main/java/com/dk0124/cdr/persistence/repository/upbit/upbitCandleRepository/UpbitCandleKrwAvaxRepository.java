package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAvaxRepository extends JpaRepository<UpbitCandleKrwAvax, Long>, UpbitCandleCommonJpaInterface {
}
