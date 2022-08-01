package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwMana;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwManaRepository extends JpaRepository<UpbitTickKrwMana, Long>, UpbitTickRepository{
        }