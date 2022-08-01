package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwEnjRepository extends JpaRepository<BithumbTickKrwEnj, Long>, BithumbTickCommonJpaInterface {
}
