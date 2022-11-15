package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwChzRepository extends JpaRepository<BithumbTickKrwChz, Long>, BithumbTickCommonJpaInterface {
}
