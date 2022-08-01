package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwPla;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwPlaRepository extends JpaRepository<UpbitTickKrwPla, Long>,UpbitTickRepository {
        }