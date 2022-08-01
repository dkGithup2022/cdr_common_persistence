package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwSandRepository extends JpaRepository<BithumbTickKrwSand, Long>, BithumbTickCommonJpaInterface {
}
