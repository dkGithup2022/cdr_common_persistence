package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;

import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwBtg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwBtgRepository extends JpaRepository<UpbitTickKrwBtg, Long>, UpbitTickRepository {
}