package com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository;

import com.dk0124.cdr.persistence.entity.bithumb.tick.coins.BithumbTickKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BithumbTickKrwMaticRepository extends JpaRepository<BithumbTickKrwMatic, Long>, BithumbTickRepository {
}
