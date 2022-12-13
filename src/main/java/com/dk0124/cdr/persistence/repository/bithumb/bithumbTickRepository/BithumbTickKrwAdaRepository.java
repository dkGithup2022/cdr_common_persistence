package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwAdaRepository extends JpaRepository<BithumbTickKrwAda, Long>, BithumbTickRepository {
}
