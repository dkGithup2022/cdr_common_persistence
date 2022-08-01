package com.dk0124.cdr.repository.upbit.upbitTickRepository;


import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwAtom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpbitTickKrwAtomRepository extends JpaRepository<UpbitTickKrwAtom, Long>, UpbitTickRepository {
}

