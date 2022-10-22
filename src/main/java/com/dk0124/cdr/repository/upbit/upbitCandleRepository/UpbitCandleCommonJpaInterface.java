package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.entity.upbit.candle.UpbitCandle;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UpbitCandleCommonJpaInterface {
    UpbitCandle save(UpbitCandle candle);
    UpbitCandle findOneByTimestamp(long timestamp);
    List<UpbitCandle> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
