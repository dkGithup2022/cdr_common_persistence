package com.dk0124.cdr.repositoryPicker.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.repository.bithumb.bithumbTickRepository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class BithumbTickRepositoryPicker {

    private final BithumbTickKrwDotRepository bithumbTickKrwDotRepository;
    private final BithumbTickKrwSolRepository bithumbTickKrwSolRepository;
    private final BithumbTickKrwAdaRepository bithumbTickKrwAdaRepository;
    private final BithumbTickKrwAtomRepository bithumbTickKrwAtomRepository;
    private final BithumbTickKrwAvaxRepository bithumbTickKrwAvaxRepository;
    private final BithumbTickKrwAxsRepository bithumbTickKrwAxsRepository;
    private final BithumbTickKrwBatRepository bithumbTickKrwBatRepository;
    private final BithumbTickKrwBchRepository bithumbTickKrwBchRepository;
    private final BithumbTickKrwBtcRepository bithumbTickKrwBtcRepository;
    private final BithumbTickKrwBtgRepository bithumbTickKrwBtgRepository;
    private final BithumbTickKrwChzRepository bithumbTickKrwChzRepository;
    private final BithumbTickKrwDogeRepository bithumbTickKrwDogeRepository;
    private final BithumbTickKrwEnjRepository bithumbTickKrwEnjRepository;
    private final BithumbTickKrwEthRepository bithumbTickKrwEthRepository;
    private final BithumbTickKrwEtcRepository bithumbTickKrwEtcRepository;
    private final BithumbTickKrwManaRepository bithumbTickKrwManaRepository;
    private final BithumbTickKrwMaticRepository bithumbTickKrwMaticRepository;
    private final BithumbTickKrwPlaRepository bithumbTickKrwPlaRepository;
    private final BithumbTickKrwSandRepository bithumbTickKrwSandRepository;
    private final BithumbTickKrwSrmRepository bithumbTickKrwSrmRepository;
    private final BithumbTickKrwXrpRepository bithumbTickKrwXrpRepository;


    public BithumbTickCommonJpaInterface getRepositoryFromCode(BithumbCoinCode code) {
        switch (code) {
            case KRW_ADA:
                return bithumbTickKrwAdaRepository;
            case KRW_ATOM:
                return bithumbTickKrwAtomRepository;
            case KRW_AVAX:
                return bithumbTickKrwAvaxRepository;
            case KRW_AXS:
                return bithumbTickKrwAxsRepository;
            case KRW_BAT:
                return bithumbTickKrwBatRepository;
            case KRW_BCH:
                return bithumbTickKrwBchRepository;
            case KRW_BTC:
                return bithumbTickKrwBtcRepository;
            case KRW_BTG:
                return bithumbTickKrwBtgRepository;
            case KRW_CHZ:
                return bithumbTickKrwChzRepository;
            case KRW_DOGE:
                return bithumbTickKrwDogeRepository;
            case KRW_DOT:
                return bithumbTickKrwDotRepository;
            case KRW_ENJ:
                return bithumbTickKrwEnjRepository;
            case KRW_ETH:
                return bithumbTickKrwEthRepository;
            case KRW_ETC:
                return bithumbTickKrwEtcRepository;
            case KRW_MANA:
                return bithumbTickKrwManaRepository;
            case KRW_MATIC:
                return bithumbTickKrwMaticRepository;
            case KRW_PLA:
                return bithumbTickKrwPlaRepository;
            case KRW_SAND:
                return bithumbTickKrwSandRepository;
            case KRW_SRM:
                return bithumbTickKrwSrmRepository;
            case KRW_SOL:
                return bithumbTickKrwSolRepository;
            case KRW_XRP:
                return bithumbTickKrwXrpRepository;
            default:
                log.error("BithumbTickRespositoryPicker.getRepositoryFromCode , when code :  {}", code);
                throw new IllegalStateException("BithumbTickRespositoryPicker.getRepositoryFromCode , when code :  {}"+ code);
        }
    }

}
