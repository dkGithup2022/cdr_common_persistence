package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwSrmRepository extends JpaRepository<BithumbTickKrwSrm, Long>, BithumbTickCommonJpaInterface {
}
