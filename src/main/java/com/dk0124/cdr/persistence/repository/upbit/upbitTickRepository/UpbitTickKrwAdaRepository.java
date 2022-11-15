package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwAda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAdaRepository extends JpaRepository<UpbitTickKrwAda, Long>, UpbitTickRepository {
}

