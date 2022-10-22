package com.dk0124.cdr.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.entity.abstraction.Candle;
import com.dk0124.cdr.entity.bithumb.candle.BithumbCandle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BithumbCandleCommonJpaInterface {
    BithumbCandle save(BithumbCandle bithumbCandle);
    BithumbCandle findOneByTimestamp(Long timestamp);
    List<BithumbCandle> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
