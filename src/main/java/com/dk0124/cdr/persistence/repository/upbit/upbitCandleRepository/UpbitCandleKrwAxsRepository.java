package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAxsRepository extends JpaRepository<UpbitCandleKrwAxs, Long>, UpbitCandleCommonJpaInterface {
}
