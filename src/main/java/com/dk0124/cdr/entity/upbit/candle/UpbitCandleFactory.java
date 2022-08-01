package com.dk0124.cdr.entity.upbit.candle;

import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.entity.upbit.candle.coin.*;

import org.modelmapper.ModelMapper;

public class UpbitCandleFactory {
    private final static ModelMapper modelMapper = new ModelMapper();

    public static UpbitCandle of(UpbitCandle candle) {
        UpbitCoinCode upbitCoinCode = UpbitCoinCode.fromString(candle.getMarket());
        switch (upbitCoinCode) {
            case KRW_ADA:
                return modelMapper.map(candle, UpbitCandleKrwAda.class);
            case KRW_ATOM:
                return modelMapper.map(candle, UpbitCandleKrwAtom.class);
            case KRW_AVAX:
                return modelMapper.map(candle, UpbitCandleKrwAvax.class);
            case KRW_AXS:
                return modelMapper.map(candle, UpbitCandleKrwAxs.class);
            case KRW_BAT:
                return modelMapper.map(candle, UpbitCandleKrwBat.class);
            case KRW_BCH:
                return modelMapper.map(candle, UpbitCandleKrwBch.class);
            case KRW_BTC:
                return modelMapper.map(candle, UpbitCandleKrwBtc.class);
            case KRW_BTG:
                return modelMapper.map(candle, UpbitCandleKrwBtg.class);
            case KRW_CHZ:
                return modelMapper.map(candle, UpbitCandleKrwChz.class);
            case KRW_DOGE:
                return modelMapper.map(candle, UpbitCandleKrwDoge.class);
            case KRW_DOT:
                return modelMapper.map(candle, UpbitCandleKrwDot.class);
            case KRW_ENJ:
                return modelMapper.map(candle, UpbitCandleKrwEnj.class);
            case KRW_ETC:
                return modelMapper.map(candle, UpbitCandleKrwEtc.class);
            case KRW_ETH:
                return modelMapper.map(candle, UpbitCandleKrwEth.class);
            case KRW_FLOW:
                return modelMapper.map(candle, UpbitCandleKrwFlow.class);
            case KRW_MANA:
                return modelMapper.map(candle, UpbitCandleKrwMana.class);
            case KRW_MATIC:
                return modelMapper.map(candle, UpbitCandleKrwMatic.class);
            case KRW_PLA:
                return modelMapper.map(candle, UpbitCandleKrwPla.class);
            case KRW_SAND:
                return modelMapper.map(candle, UpbitCandleKrwSand.class);
            case KRW_SOL:
                return modelMapper.map(candle, UpbitCandleKrwSol.class);
            case KRW_SRM:
                return modelMapper.map(candle, UpbitCandleKrwSrm.class);
            case KRW_STX:
                return modelMapper.map(candle, UpbitCandleKrwStx.class);
            case KRW_XRP:
                return modelMapper.map(candle, UpbitCandleKrwXrp.class);
            default:
                throw new IllegalArgumentException("wrong market string :" + candle);
        }
    }
}

