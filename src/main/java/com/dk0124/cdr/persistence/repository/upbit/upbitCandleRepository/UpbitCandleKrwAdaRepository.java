package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAdaRepository extends JpaRepository<UpbitCandleKrwAda, Long>, UpbitCandleRepository {
}
