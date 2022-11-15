package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;

import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwDot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwDotRepository extends JpaRepository<UpbitTickKrwDot, Long>, UpbitTickRepository {
}

