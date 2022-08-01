package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwEthRepository extends JpaRepository<BithumbTickKrwEth, Long>, BithumbTickCommonJpaInterface {
}
