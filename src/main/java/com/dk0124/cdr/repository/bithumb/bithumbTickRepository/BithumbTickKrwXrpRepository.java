package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwXrpRepository extends JpaRepository<BithumbTickKrwXrp, Long>, BithumbTickCommonJpaInterface {
}
