package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwAxs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAxsRepository extends JpaRepository<UpbitTickKrwAxs, Long>, UpbitTickRepository {
        }
