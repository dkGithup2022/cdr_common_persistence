package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;


import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbook;
import com.dk0124.cdr.entity.bithumb.tick.BithumbTick;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BithumbTickCommonJpaInterface {

    BithumbTick save(BithumbTick tick);
    BithumbTick findOneById(Long id);
    List<BithumbTick> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
