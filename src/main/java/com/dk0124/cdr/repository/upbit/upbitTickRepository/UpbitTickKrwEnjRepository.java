package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwEnj;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwEnjRepository extends JpaRepository<UpbitTickKrwEnj, Long>, UpbitTickRepository {
        }