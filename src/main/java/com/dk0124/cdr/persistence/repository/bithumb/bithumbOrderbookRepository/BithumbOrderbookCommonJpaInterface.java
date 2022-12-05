package com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbook;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BithumbOrderbookCommonJpaInterface {
    BithumbOrderbook save(BithumbOrderbook bithumbOrderbook);
    BithumbOrderbook findOneByDatetime(Long datetime);
    List<BithumbOrderbook> findByDatetimeLessThanEqual(Long datetime, Pageable pageable);
}
