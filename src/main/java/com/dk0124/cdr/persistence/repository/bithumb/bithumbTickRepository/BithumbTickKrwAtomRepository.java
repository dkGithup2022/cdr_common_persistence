package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAtomRepository extends JpaRepository<BithumbTickKrwAtom, Long>, BithumbTickRepository {
}
