package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwFlow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwFlowRepository extends JpaRepository<UpbitTickKrwFlow, Long>, UpbitTickRepository {
        }