package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwDotRepository extends JpaRepository<BithumbTickKrwDot, Long>, BithumbTickCommonJpaInterface {
}
