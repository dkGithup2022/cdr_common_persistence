package com.dk0124.cdr.repositoryPicker.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.repository.bithumb.bithumbCandleRepository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BithumbCandleRepositoryPicker {

    private final BithumbCandleKrwDotRepository bithumbCandleKrwDotRepository;
    private final BithumbCandleKrwSolRepository bithumbCandleKrwSolRepository;
    private final BithumbCandleKrwAdaRepository bithumbCandleKrwAdaRepository;
    private final BithumbCandleKrwAtomRepository bithumbCandleKrwAtomRepository;
    private final BithumbCandleKrwAvaxRepository bithumbCandleKrwAvaxRepository;
    private final BithumbCandleKrwAxsRepository bithumbCandleKrwAxsRepository;
    private final BithumbCandleKrwBatRepository bithumbCandleKrwBatRepository;
    private final BithumbCandleKrwBchRepository bithumbCandleKrwBchRepository;
    private final BithumbCandleKrwBtcRepository bithumbCandleKrwBtcRepository;
    private final BithumbCandleKrwBtgRepository bithumbCandleKrwBtgRepository;
    private final BithumbCandleKrwChzRepository bithumbCandleKrwChzRepository;
    private final BithumbCandleKrwDogeRepository bithumbCandleKrwDogeRepository;
    private final BithumbCandleKrwEnjRepository bithumbCandleKrwEnjRepository;
    private final BithumbCandleKrwEthRepository bithumbCandleKrwEthRepository;
    private final BithumbCandleKrwEtcRepository bithumbCandleKrwEtcRepository;
    private final BithumbCandleKrwManaRepository bithumbCandleKrwManaRepository;
    private final BithumbCandleKrwMaticRepository bithumbCandleKrwMaticRepository;
    private final BithumbCandleKrwPlaRepository bithumbCandleKrwPlaRepository;
    private final BithumbCandleKrwSandRepository bithumbCandleKrwSandRepository;
    private final BithumbCandleKrwSrmRepository bithumbCandleKrwSrmRepository;
    private final BithumbCandleKrwXrpRepository bithumbCandleKrwXrpRepository;

    public BithumbCandleCommonJpaInterface getRepositoryFromCode(BithumbCoinCode code) {
        switch (code) {
            case KRW_ADA:
                return bithumbCandleKrwAdaRepository;
            case KRW_ATOM:
                return bithumbCandleKrwAtomRepository;
            case KRW_AVAX:
                return bithumbCandleKrwAvaxRepository;
            case KRW_AXS:
                return bithumbCandleKrwAxsRepository;
            case KRW_BAT:
                return bithumbCandleKrwBatRepository;
            case KRW_BCH:
                return bithumbCandleKrwBchRepository;
            case KRW_BTC:
                return bithumbCandleKrwBtcRepository;
            case KRW_BTG:
                return bithumbCandleKrwBtgRepository;
            case KRW_CHZ:
                return bithumbCandleKrwChzRepository;
            case KRW_DOGE:
                return bithumbCandleKrwDogeRepository;
            case KRW_DOT:
                return bithumbCandleKrwDotRepository;
            case KRW_ENJ:
                return bithumbCandleKrwEnjRepository;
            case KRW_ETH:
                return bithumbCandleKrwEthRepository;
            case KRW_ETC:
                return bithumbCandleKrwEtcRepository;
            case KRW_MANA:
                return bithumbCandleKrwManaRepository;
            case KRW_MATIC:
                return bithumbCandleKrwMaticRepository;
            case KRW_PLA:
                return bithumbCandleKrwPlaRepository;
            case KRW_SAND:
                return bithumbCandleKrwSandRepository;
            case KRW_SRM:
                return bithumbCandleKrwSrmRepository;
            case KRW_SOL:
                return bithumbCandleKrwSolRepository;
            case KRW_XRP:
                return bithumbCandleKrwXrpRepository;
            default:
                log.error("BithumbCandleRespositoryPicker.getRepositoryFromCode , when code :  {}", code);
                throw new IllegalStateException("BithumbCandleRespositoryPicker.getRepositoryFromCode , when code :  {}"+ code);
        }
    }
}
