package com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbook;

public interface BithumbOrderbookCommonJpaInterface {
    BithumbOrderbook save(BithumbOrderbook bithumbOrderbook);
    BithumbOrderbook findOneByDatetime(Long datetime);
}
