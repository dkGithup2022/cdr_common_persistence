package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwMaticRepository extends JpaRepository<BithumbTickKrwMatic, Long>, BithumbTickCommonJpaInterface {
}
