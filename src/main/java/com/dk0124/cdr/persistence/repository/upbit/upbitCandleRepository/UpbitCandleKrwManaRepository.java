package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwManaRepository extends JpaRepository<UpbitCandleKrwMana, Long>, UpbitCandleRepository {
}
