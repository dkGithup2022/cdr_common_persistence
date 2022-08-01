package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.bithumb.candle.BithumbCandle;

public interface BithumbCandleCommonJpaInterface {
    BithumbCandle save(BithumbCandle bithumbCandle);
    BithumbCandle findOneByTimestamp(Long timestamp);
}
