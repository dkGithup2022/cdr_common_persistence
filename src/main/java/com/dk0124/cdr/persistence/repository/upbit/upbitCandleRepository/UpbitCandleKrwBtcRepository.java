package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwBtcRepository extends JpaRepository<UpbitCandleKrwBtc, Long>, UpbitCandleRepository {
}
