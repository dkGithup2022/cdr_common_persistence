package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwSandRepository extends JpaRepository<UpbitCandleKrwSand, Long>, UpbitCandleRepository {
}
