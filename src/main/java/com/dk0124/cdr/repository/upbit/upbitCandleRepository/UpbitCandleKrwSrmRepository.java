package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwSrmRepository extends JpaRepository<UpbitCandleKrwSrm, Long>,UpbitCandleCommonJpaInterface {
}
