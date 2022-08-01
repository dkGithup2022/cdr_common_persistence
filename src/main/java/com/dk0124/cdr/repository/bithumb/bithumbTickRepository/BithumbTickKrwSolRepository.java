package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwSolRepository extends JpaRepository<BithumbTickKrwSol, Long>, BithumbTickCommonJpaInterface {
}
