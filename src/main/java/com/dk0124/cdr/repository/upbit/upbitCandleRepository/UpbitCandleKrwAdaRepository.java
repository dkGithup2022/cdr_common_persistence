package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAdaRepository extends JpaRepository<UpbitCandleKrwAda, Long>, UpbitCandleCommonJpaInterface {
}
