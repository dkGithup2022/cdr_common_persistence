package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwSand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwSandRepository extends JpaRepository<UpbitTickKrwSand, Long>, UpbitTickRepository {
        }