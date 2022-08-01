package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwBch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwBchRepository extends JpaRepository<UpbitTickKrwBch, Long>, UpbitTickRepository {
}