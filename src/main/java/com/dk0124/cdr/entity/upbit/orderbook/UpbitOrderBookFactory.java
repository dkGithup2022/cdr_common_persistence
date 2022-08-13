package com.dk0124.cdr.entity.upbit.orderbook;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.entity.upbit.orderbook.UpbitOrderbook;
import com.dk0124.cdr.entity.upbit.orderbook.coins.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class UpbitOrderBookFactory {

    //TODO : 빈 객체의  model Mapper 가져오기
    private final static ModelMapper modelMapper = new ModelMapper();


    public static UpbitOrderbook of(UpbitOrderbook upbitOrderbook){
        UpbitCoinCode upbitCoinCode =UpbitCoinCode.fromString( upbitOrderbook.getCode());
        switch (upbitCoinCode){

            case KRW_ADA:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwAda.class);
            case KRW_ATOM:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwAtom.class);
            case KRW_AVAX:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwAvax.class);
            case KRW_AXS:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwAxs.class);
            case KRW_BAT:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwBat.class);
            case KRW_BCH:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwBch.class);
            case KRW_BTC:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwBtc.class);
            case KRW_BTG:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwBtg.class);
            case KRW_CHZ:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwChz.class);
            case KRW_DOGE:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwDoge.class);
            case KRW_DOT:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwDot.class);
            case KRW_ENJ:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwEnj.class);
            case KRW_ETC:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwEtc.class);
            case KRW_ETH:
                return modelMapper.map(upbitOrderbook,UpbitOrderbookKrwEth.class);
            case KRW_FLOW:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwFlow.class);
            case KRW_MANA:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwMana.class);
            case KRW_MATIC:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwMatic.class);
            case KRW_PLA:
                return modelMapper.map(upbitOrderbook,UpbitOrderbookKrwPla.class);
            case KRW_SAND:
                return modelMapper.map(upbitOrderbook,UpbitOrderbookKrwSand.class);
            case KRW_SRM:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwSrm.class);
            case KRW_STX:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwStx.class);
            case KRW_SOL:
                return modelMapper.map(upbitOrderbook, UpbitOrderbookKrwSol.class);
            case KRW_XRP:
                return modelMapper.map(upbitOrderbook,UpbitOrderbookKrwXrp.class);

            default:
                log.error(" UpbitTickFactory.of | when coin :  {}" ,upbitOrderbook.getCode());
                throw new IllegalArgumentException("wrong market code :"+upbitOrderbook.getCode() );
        }
    }
}
