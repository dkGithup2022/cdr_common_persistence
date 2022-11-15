package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;


import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTick;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BithumbTickCommonJpaInterface {

    BithumbTick save(BithumbTick tick);
    BithumbTick findOneById(Long id);
    List<BithumbTick> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
