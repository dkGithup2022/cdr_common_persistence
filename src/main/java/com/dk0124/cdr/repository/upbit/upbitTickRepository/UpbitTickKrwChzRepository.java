package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwChz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwChzRepository extends JpaRepository<UpbitTickKrwChz, Long>, UpbitTickRepository {
        }