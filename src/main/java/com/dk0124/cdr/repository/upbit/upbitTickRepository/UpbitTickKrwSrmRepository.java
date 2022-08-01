package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwSrm;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UpbitTickKrwSrmRepository extends JpaRepository<UpbitTickKrwSrm, Long>, UpbitTickRepository {
        }