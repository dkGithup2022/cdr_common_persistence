package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwBatRepository extends JpaRepository<BithumbTickKrwBat, Long>, BithumbTickRepository {
}
