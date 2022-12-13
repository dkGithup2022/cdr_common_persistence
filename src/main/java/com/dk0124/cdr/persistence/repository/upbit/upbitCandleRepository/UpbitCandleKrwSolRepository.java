package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwSolRepository extends JpaRepository<UpbitCandleKrwSol, Long>, UpbitCandleRepository {
}
