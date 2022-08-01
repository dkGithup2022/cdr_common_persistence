package com.dk0124.cdr.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.entity.bithumb.tick.coins.BithumbTickKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAtomRepository extends JpaRepository<BithumbTickKrwAtom, Long>, BithumbTickCommonJpaInterface {
}
