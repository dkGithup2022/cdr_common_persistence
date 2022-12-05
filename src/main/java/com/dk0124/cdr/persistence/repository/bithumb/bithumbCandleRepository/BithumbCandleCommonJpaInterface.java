package com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository;

import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandle;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BithumbCandleCommonJpaInterface {
    BithumbCandle save(BithumbCandle bithumbCandle);
    BithumbCandle findOneByTimestamp(Long timestamp);
    List<BithumbCandle> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
