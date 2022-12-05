package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwAvax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAvaxRepository extends JpaRepository<UpbitTickKrwAvax, Long>, UpbitTickRepository {
}