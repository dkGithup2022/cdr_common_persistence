package com.dk0124.cdr.repository.upbit.upbitOrderBookRepository;


import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderbook;

public interface UpbitOrderbookCommonRepository{
    UpbitOrderbook save(UpbitOrderbook upbitOrderbook);
    UpbitOrderbook findOneByTimestamp(Long timestamp);
}
