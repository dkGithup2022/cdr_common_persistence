package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwPlaRepository extends JpaRepository<BithumbTickKrwPla, Long>, BithumbTickRepository {
}
