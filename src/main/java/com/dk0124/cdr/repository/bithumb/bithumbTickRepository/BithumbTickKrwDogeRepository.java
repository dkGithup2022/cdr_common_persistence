package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwDogeRepository extends JpaRepository<BithumbTickKrwDoge, Long>, BithumbTickCommonJpaInterface {
}
