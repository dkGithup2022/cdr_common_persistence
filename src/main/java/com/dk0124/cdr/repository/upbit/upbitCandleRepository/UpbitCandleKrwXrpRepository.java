package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwXrpRepository extends JpaRepository<UpbitCandleKrwXrp, Long>, UpbitCandleCommonJpaInterface {
}
