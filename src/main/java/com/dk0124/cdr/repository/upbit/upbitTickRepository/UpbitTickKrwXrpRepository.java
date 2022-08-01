package com.dk0124.cdr.repository.upbit.upbitTickRepository;

import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwXrp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwXrpRepository extends JpaRepository<UpbitTickKrwXrp,Long>, UpbitTickRepository {
}
