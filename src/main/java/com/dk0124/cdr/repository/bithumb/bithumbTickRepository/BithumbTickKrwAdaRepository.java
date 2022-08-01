package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAdaRepository extends JpaRepository<BithumbTickKrwAda, Long>, BithumbTickCommonJpaInterface {
}
