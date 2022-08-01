package com.dk0124.cdr.entity.upbit.tick;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.entity.upbit.tick.coins.*;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpbitTickFactory {
    //TODO : 빈 객체의  model Mapper 가져오기
    private final static ModelMapper modelMapper = new ModelMapper();


    public static UpbitTick of(UpbitTick upbitTick){
        UpbitCoinCode upbitCoinCode =UpbitCoinCode.fromString( upbitTick.getCode());
        switch (upbitCoinCode){

            case KRW_ADA:
                return modelMapper.map(upbitTick, UpbitTickKrwAda.class);
            case KRW_ATOM:
                return modelMapper.map(upbitTick, UpbitTickKrwAtom.class);
            case KRW_AVAX:
                return modelMapper.map(upbitTick, UpbitTickKrwAvax.class);
            case KRW_AXS:
                return modelMapper.map(upbitTick, UpbitTickKrwAxs.class);
            case KRW_BAT:
                return modelMapper.map(upbitTick, UpbitTickKrwBat.class);
            case KRW_BCH:
                return modelMapper.map(upbitTick, UpbitTickKrwBch.class);
            case KRW_BTC:
                return modelMapper.map(upbitTick, UpbitTickKrwBtc.class);
            case KRW_BTG:
                return modelMapper.map(upbitTick, UpbitTickKrwBtg.class);
            case KRW_CHZ:
                return modelMapper.map(upbitTick, UpbitTickKrwChz.class);
            case KRW_DOGE:
                return modelMapper.map(upbitTick, UpbitTickKrwDoge.class);
            case KRW_DOT:
                return modelMapper.map(upbitTick, UpbitTickKrwDot.class);
            case KRW_ENJ:
                return modelMapper.map(upbitTick, UpbitTickKrwEnj.class);
            case KRW_ETC:
                return modelMapper.map(upbitTick, UpbitTickKrwEtc.class);
            case KRW_ETH:
                return modelMapper.map(upbitTick, UpbitTickKrwEth.class);
            case KRW_FLOW:
                return modelMapper.map(upbitTick, UpbitTickKrwFlow.class);
            case KRW_MANA:
                return modelMapper.map(upbitTick, UpbitTickKrwMana.class);
            case KRW_MATIC:
                return modelMapper.map(upbitTick, UpbitTickKrwMatic.class);
            case KRW_PLA:
                return modelMapper.map(upbitTick, UpbitTickKrwPla.class);
            case KRW_SAND:
                return modelMapper.map(upbitTick, UpbitTickKrwSand.class);
            case KRW_SRM:
                return modelMapper.map(upbitTick, UpbitTickKrwSrm.class);
            case KRW_STX:
                return modelMapper.map(upbitTick, UpbitTickKrwStx.class);
            case KRW_SOL:
                return modelMapper.map(upbitTick, UpbitTickKrwSol.class);
            case KRW_XRP:
                return modelMapper.map(upbitTick, UpbitTickKrwXrp.class);

            default:
                log.error(" UpbitTickFactory.of | when coin :  {}" ,upbitTick.getCode());
                throw new IllegalArgumentException(" UpbitTickFactory.of | when coin :  " + upbitTick.getCode());
        }
    }

}
