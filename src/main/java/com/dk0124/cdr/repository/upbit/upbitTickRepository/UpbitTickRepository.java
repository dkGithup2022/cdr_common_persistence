package com.dk0124.cdr.repository.upbit.upbitTickRepository;

import com.dk0124.cdr.entity.upbit.tick.UpbitTick;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UpbitTickRepository {
    UpbitTick save(UpbitTick upbitTick);

    UpbitTick findBySequentialId(Long sequentialId);
    List<UpbitTick> findByTimestampBetweenOrderByTimestampDesc(Long old, Long now);
}
