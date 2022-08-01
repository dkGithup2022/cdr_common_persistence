package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwBat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwBatRepository extends JpaRepository<UpbitTickKrwBat, Long>, UpbitTickRepository {
        }