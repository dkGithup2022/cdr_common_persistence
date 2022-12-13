package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwBtgRepository extends JpaRepository<BithumbTickKrwBtg, Long>, BithumbTickRepository {
}
