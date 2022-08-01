package com.dk0124.cdr.entity.bithumb.orderbook;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.entity.bithumb.orderbook.coins.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BithumbOrderbookFactory {
    private final static ModelMapper modelMapper = new ModelMapper();


    public static BithumbOrderbook of(BithumbOrderbook bithumOrderbook){
        BithumbCoinCode bithumbCoinCode = BithumbCoinCode.fromString(bithumOrderbook.getCode());
        switch (bithumbCoinCode){
            case KRW_ADA:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwAda.class);
            case KRW_ATOM:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwAtom.class);
            case KRW_AVAX:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwAvax.class);
            case KRW_AXS:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwAxs.class);
            case KRW_BAT:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwBat.class);
            case KRW_BCH:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwBch.class);
            case KRW_BTC:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwBtc.class);
            case KRW_BTG:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwBtg.class);
            case KRW_CHZ:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwChz.class);
            case KRW_DOGE:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwDoge.class);
            case KRW_DOT:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwDot.class);
            case KRW_ENJ:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwEnj.class);
            case KRW_ETC:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwEtc.class);
            case KRW_ETH:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwEth.class);
            case KRW_MANA:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwMana.class);
            case KRW_MATIC:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwMatic.class);
            case KRW_PLA:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwPla.class);
            case KRW_SAND:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwSand.class);
            case KRW_SRM:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwSrm.class);
            case KRW_SOL:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwSol.class);
            case KRW_XRP:
                return modelMapper.map(bithumOrderbook, BithumbOrderbookKrwXrp.class);

            default:
                log.error("BithumbOrderbookTickFactory.of | when coin :  {}" ,bithumOrderbook.getCode());
                throw new IllegalArgumentException("BithumbOrderbookTickFactory.of code :" + bithumOrderbook.getCode());
        }
    }
}
