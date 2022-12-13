package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;


import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UpbitOrderbookRepository {
    UpbitOrderbook save(UpbitOrderbook upbitOrderbook);
    UpbitOrderbook findOneByTimestamp(Long timestamp);
    Page<UpbitOrderbook> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
