package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwEth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwEthRepository extends JpaRepository<UpbitTickKrwEth, Long>, UpbitTickRepository {
        }