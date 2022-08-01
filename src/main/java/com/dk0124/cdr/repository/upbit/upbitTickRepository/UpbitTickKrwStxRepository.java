package com.dk0124.cdr.repository.upbit.upbitTickRepository;

import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwStx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwStxRepository extends JpaRepository<UpbitTickKrwStx,Long>, UpbitTickRepository {
}
