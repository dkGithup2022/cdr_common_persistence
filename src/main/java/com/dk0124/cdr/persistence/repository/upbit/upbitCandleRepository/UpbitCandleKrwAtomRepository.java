package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;


import com.dk0124.cdr.persistence.entity.upbit.candle.coin.UpbitCandleKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitCandleKrwAtomRepository extends JpaRepository<UpbitCandleKrwAtom, Long>, UpbitCandleRepository {
}
