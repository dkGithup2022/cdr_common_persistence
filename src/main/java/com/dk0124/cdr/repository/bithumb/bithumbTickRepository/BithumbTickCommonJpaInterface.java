package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;


import com.dk0124.cdr.entity.bithumb.tick.BithumbTick;

public interface BithumbTickCommonJpaInterface {

    BithumbTick save(BithumbTick tick);
    BithumbTick findOneById(Long id);
}
