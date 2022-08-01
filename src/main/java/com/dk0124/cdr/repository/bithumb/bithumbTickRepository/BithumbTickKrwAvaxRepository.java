package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAvaxRepository extends JpaRepository<BithumbTickKrwAvax, Long>, BithumbTickCommonJpaInterface {
}
