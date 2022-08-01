package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwMaticRepository extends JpaRepository<UpbitCandleKrwMatic, Long>, UpbitCandleCommonJpaInterface {
}
