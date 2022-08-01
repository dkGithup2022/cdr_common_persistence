package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwFlowRepository extends JpaRepository<UpbitCandleKrwFlow, Long>, UpbitCandleCommonJpaInterface {
}
