package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwBtcRepository extends JpaRepository<BithumbTickKrwBtc, Long>, BithumbTickCommonJpaInterface {
}
