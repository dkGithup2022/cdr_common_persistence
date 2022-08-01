package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.coin.UpbitCandleKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwManaRepository extends JpaRepository<UpbitCandleKrwMana, Long>,UpbitCandleCommonJpaInterface {
}
