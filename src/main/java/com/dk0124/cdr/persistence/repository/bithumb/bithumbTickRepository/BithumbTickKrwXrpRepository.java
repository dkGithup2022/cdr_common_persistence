package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwXrpRepository extends JpaRepository<BithumbTickKrwXrp, Long>, BithumbTickRepository {
}
