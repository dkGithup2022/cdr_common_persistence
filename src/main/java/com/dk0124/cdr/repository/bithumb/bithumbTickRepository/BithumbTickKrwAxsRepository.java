package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAxsRepository extends JpaRepository<BithumbTickKrwAxs, Long>, BithumbTickCommonJpaInterface {
}
