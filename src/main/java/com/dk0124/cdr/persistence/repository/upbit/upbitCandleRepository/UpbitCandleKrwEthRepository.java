package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwEthRepository extends JpaRepository<UpbitCandleKrwEth, Long>, UpbitCandleRepository {
}
