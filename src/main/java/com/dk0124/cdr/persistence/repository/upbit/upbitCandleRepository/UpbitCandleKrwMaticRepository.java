package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwMaticRepository extends JpaRepository<UpbitCandleKrwMatic, Long>, UpbitCandleCommonJpaInterface {
}
