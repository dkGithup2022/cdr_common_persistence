package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwBchRepository extends JpaRepository<BithumbTickKrwBch, Long>, BithumbTickRepository {
}
