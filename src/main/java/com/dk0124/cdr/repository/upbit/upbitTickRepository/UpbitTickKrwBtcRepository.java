package com.dk0124.cdr.repository.upbit.upbitTickRepository;

import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwBtc;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UpbitTickKrwBtcRepository extends JpaRepository<UpbitTickKrwBtc, Long>, UpbitTickRepository {
}