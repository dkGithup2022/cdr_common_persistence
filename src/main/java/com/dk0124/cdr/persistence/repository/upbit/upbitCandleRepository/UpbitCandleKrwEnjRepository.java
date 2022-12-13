package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwEnjRepository extends JpaRepository<UpbitCandleKrwEnj, Long>, UpbitCandleRepository {
}
