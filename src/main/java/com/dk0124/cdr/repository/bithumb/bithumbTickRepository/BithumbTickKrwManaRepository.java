package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwManaRepository extends JpaRepository<BithumbTickKrwMana, Long>, BithumbTickCommonJpaInterface {
}
