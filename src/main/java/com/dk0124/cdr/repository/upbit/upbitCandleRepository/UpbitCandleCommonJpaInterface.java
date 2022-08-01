package com.dk0124.cdr.repository.upbit.upbitCandleRepository;

import com.dk0124.cdr.entity.upbit.candle.UpbitCandle;

public interface UpbitCandleCommonJpaInterface {
    UpbitCandle save(UpbitCandle candle);
    UpbitCandle findOneByTimestamp(long timestamp);
}
