package com.dk0124.cdr.repositoryPicker.upbit;


import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.repository.upbit.upbitOrderBookRepository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpbitOrderbookRepositoryPicker {
    private final UpbitOrderbookKrwAdaRepository upbitOrderbookKrwAdaRepository;
    private final UpbitOrderbookKrwAtomRepository upbitOrderbookKrwAtomRepository;
    private final UpbitOrderbookKrwAvaxRepository upbitOrderbookKrwAvaxRepository;
    private final UpbitOrderbookKrwAxsRepository upbitOrderbookKrwAxsRepository;
    private final UpbitOrderbookKrwBatRepository upbitOrderbookKrwBatRepository;
    private final UpbitOrderbookKrwBchRepository upbitOrderbookKrwBchRepository;
    private final UpbitOrderbookKrwBtcRepository upbitOrderbookKrwBtcRepository;
    private final UpbitOrderbookKrwBtgRepository upbitOrderbookKrwBtgRepository;
    private final UpbitOrderbookKrwChzRepository upbitOrderbookKrwChzRepository;
    private final UpbitOrderbookKrwDogeRepository upbitOrderbookKrwDogeRepository;
    private final UpbitOrderbookKrwDotRepository upbitOrderbookKrwDotRepository;
    private final UpbitOrderbookKrwEnjRepository upbitOrderbookKrwEnjRepository;
    private final UpbitOrderbookKrwEtcRepository upbitOrderbookKrwEtcRepository;
    private final UpbitOrderbookKrwEthRepository upbitOrderbookKrwEthRepository;
    private final UpbitOrderbookKrwFlowRepository upbitOrderbookKrwFlowRepository;
    private final UpbitOrderbookKrwManaRepository upbitOrderbookKrwManaRepository;
    private final UpbitOrderbookKrwMaticRepository upbitOrderbookKrwMaticRepository;
    private final UpbitOrderbookKrwPlaRepository upbitOrderbookKrwPlaRepository;
    private final UpbitOrderbookKrwSandRepository upbitOrderbookKrwSandRepository;
    private final UpbitOrderbookKrwSolRepository upbitOrderbookKrwSolRepository;
    private final UpbitOrderbookKrwSrmRepository upbitOrderbookKrwSrmRepository;
    private final UpbitOrderbookKrwStxRepository upbitOrderbookKrwStxRepository;
    private final UpbitOrderbookKrwXrpRepository upbitOrderbookKrwXrpRepository;

    public UpbitOrderbookCommonRepository getRepositoryFromCode(UpbitCoinCode code) {
        switch (code) {
            case KRW_ADA:
                return upbitOrderbookKrwAdaRepository;
            case KRW_ATOM:
                return upbitOrderbookKrwAtomRepository;
            case KRW_AVAX:
                return upbitOrderbookKrwAvaxRepository;
            case KRW_AXS:
                return upbitOrderbookKrwAxsRepository;
            case KRW_BAT:
                return upbitOrderbookKrwBatRepository;
            case KRW_BCH:
                return upbitOrderbookKrwBchRepository;
            case KRW_BTC:
                return upbitOrderbookKrwBtcRepository;
            case KRW_BTG:
                return upbitOrderbookKrwBtgRepository;
            case KRW_CHZ:
                return upbitOrderbookKrwChzRepository;
            case KRW_DOGE:
                return upbitOrderbookKrwDogeRepository;
            case KRW_DOT:
                return upbitOrderbookKrwDotRepository;
            case KRW_ENJ:
                return upbitOrderbookKrwEnjRepository;
            case KRW_ETH:
                return upbitOrderbookKrwEthRepository;
            case KRW_ETC:
                return upbitOrderbookKrwEtcRepository;
            case KRW_FLOW:
                return upbitOrderbookKrwFlowRepository;
            case KRW_MANA:
                return upbitOrderbookKrwManaRepository;
            case KRW_MATIC:
                return upbitOrderbookKrwMaticRepository;
            case KRW_PLA:
                return upbitOrderbookKrwPlaRepository;
            case KRW_SAND:
                return upbitOrderbookKrwSandRepository;
            case KRW_SRM:
                return upbitOrderbookKrwSrmRepository;
            case KRW_STX:
                return upbitOrderbookKrwStxRepository;
            case KRW_SOL:
                return upbitOrderbookKrwSolRepository;
            case KRW_XRP:
                return upbitOrderbookKrwXrpRepository;

            default:
                log.error("UpbitRespositoryPicker.getRepositoryFromCode , when code :  {}", code);
                throw new IllegalStateException("UpbitOrderbookRespositoryPicker.getRepositoryFromCode , when code :  {}"+ code);
        }
    }
}
