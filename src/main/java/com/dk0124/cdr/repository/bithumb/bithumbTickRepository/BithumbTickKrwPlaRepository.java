package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwPlaRepository extends JpaRepository<BithumbTickKrwPla, Long>, BithumbTickCommonJpaInterface {
}
