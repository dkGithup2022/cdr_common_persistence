package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;


import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTick;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BithumbTickRepository {
    BithumbTick save(BithumbTick tick);
    BithumbTick findOneById(Long id);
    Page<BithumbTick> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
