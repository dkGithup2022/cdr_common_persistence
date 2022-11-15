package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwSolRepository extends JpaRepository<BithumbTickKrwSol, Long>, BithumbTickCommonJpaInterface {
}
