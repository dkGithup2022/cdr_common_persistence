package com.dk0124.cdr.persistence.repository.upbit.upbitOrderBookRepository;


import com.dk0124.cdr.persistence.entity.upbit.orderbook.UpbitOrderbook;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UpbitOrderbookCommonRepository{
    UpbitOrderbook save(UpbitOrderbook upbitOrderbook);
    UpbitOrderbook findOneByTimestamp(Long timestamp);
    List<UpbitOrderbook> findByTimestampLessThanEqual(Long timestamp, Pageable pageable);
}
