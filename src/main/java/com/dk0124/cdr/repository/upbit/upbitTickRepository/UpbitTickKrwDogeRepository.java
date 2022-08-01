package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwDoge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwDogeRepository extends JpaRepository<UpbitTickKrwDoge, Long>,UpbitTickRepository {
        }