package com.dk0124.cdr.persistence.repository.upbit.upbitTickRepository;

import com.dk0124.cdr.persistence.entity.upbit.tick.coins.UpbitTickKrwSol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwSolRepository extends JpaRepository<UpbitTickKrwSol,Long> , UpbitTickRepository{
}
