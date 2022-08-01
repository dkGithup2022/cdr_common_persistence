package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwEtc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwEtcRepository extends JpaRepository<UpbitTickKrwEtc, Long>, UpbitTickRepository {
}