package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwEtcRepository extends JpaRepository<BithumbTickKrwEtc, Long>, BithumbTickCommonJpaInterface {
}
