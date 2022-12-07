package com.dk0124.cdr.persistence.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.persistence.entity.upbit.candle.UpbitCandle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UpbitCandleCommonJpaInterface {
    UpbitCandle save(UpbitCandle candle);
    UpbitCandle findOneByTimestamp(long timestamp);
    Page<UpbitCandle> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
