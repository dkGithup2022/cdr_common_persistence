package com.dk0124.cdr.repositoryPicker.bithumb;


import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.repository.bithumb.bithumbOrderbookRepository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BithumbOrderbookRepositoryPicker {

    private final BithumbOrderbookKrwDotRepository bithumbOrderbookKrwDotRepository;
    private final BithumbOrderbookKrwSolRepository bithumbOrderbookKrwSolRepository;
    private final BithumbOrderbookKrwAdaRepository bithumbOrderbookKrwAdaRepository;
    private final BithumbOrderbookKrwAtomRepository bithumbOrderbookKrwAtomRepository;
    private final BithumbOrderbookKrwAvaxRepository bithumbOrderbookKrwAvaxRepository;
    private final BithumbOrderbookKrwAxsRepository bithumbOrderbookKrwAxsRepository;
    private final BithumbOrderbookKrwBatRepository bithumbOrderbookKrwBatRepository;
    private final BithumbOrderbookKrwBchRepository bithumbOrderbookKrwBchRepository;
    private final BithumbOrderbookKrwBtcRepository bithumbOrderbookKrwBtcRepository;
    private final BithumbOrderbookKrwBtgRepository bithumbOrderbookKrwBtgRepository;
    private final BithumbOrderbookKrwChzRepository bithumbOrderbookKrwChzRepository;
    private final BithumbOrderbookKrwDogeRepository bithumbOrderbookKrwDogeRepository;
    private final BithumbOrderbookKrwEnjRepository bithumbOrderbookKrwEnjRepository;
    private final BithumbOrderbookKrwEthRepository bithumbOrderbookKrwEthRepository;
    private final BithumbOrderbookKrwEtcRepository bithumbOrderbookKrwEtcRepository;
    private final BithumbOrderbookKrwManaRepository bithumbOrderbookKrwManaRepository;
    private final BithumbOrderbookKrwMaticRepository bithumbOrderbookKrwMaticRepository;
    private final BithumbOrderbookKrwPlaRepository bithumbOrderbookKrwPlaRepository;
    private final BithumbOrderbookKrwSandRepository bithumbOrderbookKrwSandRepository;
    private final BithumbOrderbookKrwSrmRepository bithumbOrderbookKrwSrmRepository;
    private final BithumbOrderbookKrwXrpRepository bithumbOrderbookKrwXrpRepository;

    public BithumbOrderbookCommonJpaInterface getRepositoryFromCode(BithumbCoinCode code) {
        switch (code) {
            case KRW_ADA:
                return bithumbOrderbookKrwAdaRepository;
            case KRW_ATOM:
                return bithumbOrderbookKrwAtomRepository;
            case KRW_AVAX:
                return bithumbOrderbookKrwAvaxRepository;
            case KRW_AXS:
                return bithumbOrderbookKrwAxsRepository;
            case KRW_BAT:
                return bithumbOrderbookKrwBatRepository;
            case KRW_BCH:
                return bithumbOrderbookKrwBchRepository;
            case KRW_BTC:
                return bithumbOrderbookKrwBtcRepository;
            case KRW_BTG:
                return bithumbOrderbookKrwBtgRepository;
            case KRW_CHZ:
                return bithumbOrderbookKrwChzRepository;
            case KRW_DOGE:
                return bithumbOrderbookKrwDogeRepository;
            case KRW_DOT:
                return bithumbOrderbookKrwDotRepository;
            case KRW_ENJ:
                return bithumbOrderbookKrwEnjRepository;
            case KRW_ETH:
                return bithumbOrderbookKrwEthRepository;
            case KRW_ETC:
                return bithumbOrderbookKrwEtcRepository;
            case KRW_MANA:
                return bithumbOrderbookKrwManaRepository;
            case KRW_MATIC:
                return bithumbOrderbookKrwMaticRepository;
            case KRW_PLA:
                return bithumbOrderbookKrwPlaRepository;
            case KRW_SAND:
                return bithumbOrderbookKrwSandRepository;
            case KRW_SRM:
                return bithumbOrderbookKrwSrmRepository;
            case KRW_SOL:
                return bithumbOrderbookKrwSolRepository;
            case KRW_XRP:
                return bithumbOrderbookKrwXrpRepository;
            default:
                log.error("BithumbOrderbookRespositoryPicker.getRepositoryFromCode , when code :  {}", code);
                throw new IllegalStateException("BithumbOrderbookRespositoryPicker.getRepositoryFromCode , when code :  {}"+ code);
        }
    }
}
