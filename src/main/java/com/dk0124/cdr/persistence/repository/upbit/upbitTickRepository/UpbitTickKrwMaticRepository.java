package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwMatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwMaticRepository extends JpaRepository<UpbitTickKrwMatic, Long>,UpbitTickRepository{
        }