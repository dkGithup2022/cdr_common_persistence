package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;

import com.dk0124.cdr.persistence.entity.upbit.tick.UpbitTick;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UpbitTickRepository {
    UpbitTick save(UpbitTick upbitTick);

    UpbitTick findBySequentialId(Long sequentialId);
    List<UpbitTick> findByTimestampBetweenOrderByTimestampDesc(Long old, Long now);

    List<UpbitTick> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
