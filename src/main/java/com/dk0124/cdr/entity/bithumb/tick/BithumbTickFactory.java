package com.dk0124.cdr.entity.bithumb.tick;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.entity.bithumb.tick.coins.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BithumbTickFactory {
    private final static ModelMapper modelMapper = new ModelMapper();

    public static BithumbTick of(BithumbTick bithumbTick){
        BithumbCoinCode bithumbCoinCode = BithumbCoinCode.fromString(bithumbTick.getCode());
        switch (bithumbCoinCode){
            case KRW_ADA:
                return modelMapper.map(bithumbTick, BithumbTickKrwAda.class);
            case KRW_ATOM:
                return modelMapper.map(bithumbTick, BithumbTickKrwAtom.class);
            case KRW_AVAX:
                return modelMapper.map(bithumbTick, BithumbTickKrwAvax.class);
            case KRW_AXS:
                return modelMapper.map(bithumbTick, BithumbTickKrwAxs.class);
            case KRW_BAT:
                return modelMapper.map(bithumbTick, BithumbTickKrwBat.class);
            case KRW_BCH:
                return modelMapper.map(bithumbTick, BithumbTickKrwBch.class);
            case KRW_BTC:
                return modelMapper.map(bithumbTick, BithumbTickKrwBtc.class);
            case KRW_BTG:
                return modelMapper.map(bithumbTick, BithumbTickKrwBtg.class);
            case KRW_CHZ:
                return modelMapper.map(bithumbTick, BithumbTickKrwChz.class);
            case KRW_DOGE:
                return modelMapper.map(bithumbTick, BithumbTickKrwDoge.class);
            case KRW_DOT:
                return modelMapper.map(bithumbTick, BithumbTickKrwDot.class);
            case KRW_ENJ:
                return modelMapper.map(bithumbTick, BithumbTickKrwEnj.class);
            case KRW_ETC:
                return modelMapper.map(bithumbTick, BithumbTickKrwEtc.class);
            case KRW_ETH:
                return modelMapper.map(bithumbTick, BithumbTickKrwEth.class);
            case KRW_MANA:
                return modelMapper.map(bithumbTick, BithumbTickKrwMana.class);
            case KRW_MATIC:
                return modelMapper.map(bithumbTick, BithumbTickKrwMatic.class);
            case KRW_PLA:
                return modelMapper.map(bithumbTick, BithumbTickKrwPla.class);
            case KRW_SAND:
                return modelMapper.map(bithumbTick, BithumbTickKrwSand.class);
            case KRW_SRM:
                return modelMapper.map(bithumbTick, BithumbTickKrwSrm.class);
            case KRW_SOL:
                return modelMapper.map(bithumbTick, BithumbTickKrwSol.class);
            case KRW_XRP:
                return modelMapper.map(bithumbTick, BithumbTickKrwXrp.class);

            default:
                log.error("BithumbTickTickFactory.of | when coin :  {}" ,bithumbTick.getCode());
                throw new IllegalArgumentException("BithumbTickTickFactory.of get code () " + bithumbTick.getCode());
        }
    }

}
