package com.dk0124.cdr.repositoryPicker.upbit;


import com.dk0124.cdr.constants.coinCode.UpbitCoinCode.UpbitCoinCode;
import com.dk0124.cdr.repository.upbit.upbitTickRepository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
@Slf4j
public class UpbitTickRepositoryPicker {
    private final UpbitTickKrwSolRepository upbitTickKrwSolRepository;
    private final UpbitTickKrwDotRepository upbitTickKrwDotRepository;
    private final UpbitTickKrwStxRepository upbitTickKrwStxRepository;
    private final UpbitTickKrwAdaRepository upbitTickKrwAdaRepository;
    private final UpbitTickKrwAtomRepository upbitTickKrwAtomRepository;
    private final UpbitTickKrwAvaxRepository upbitTickKrwAvaxRepository;
    private final UpbitTickKrwAxsRepository upbitTickKrwAxsRepository;
    private final UpbitTickKrwBatRepository upbitTickKrwBatRepository;
    private final UpbitTickKrwBchRepository upbitTickKrwBchRepository;
    private final UpbitTickKrwBtcRepository upbitTickKrwBtcRepository;
    private final UpbitTickKrwBtgRepository upbitTickKrwBtgRepository;
    private final UpbitTickKrwChzRepository upbitTickKrwChzRepository;
    private final UpbitTickKrwDogeRepository upbitTickKrwDogeRepository;
    private final UpbitTickKrwEnjRepository upbitTickKrwEnjRepository;
    private final UpbitTickKrwEthRepository upbitTickKrwEthRepository;
    private final UpbitTickKrwEtcRepository upbitTickKrwEtcRepository;
    private final UpbitTickKrwFlowRepository upbitTickKrwFlowRepository;
    private final UpbitTickKrwManaRepository upbitTickKrwManaRepository;
    private final UpbitTickKrwMaticRepository upbitTickKrwMaticRepository;
    private final UpbitTickKrwPlaRepository upbitTickKrwPlaRepository;
    private final UpbitTickKrwSandRepository upbitTickKrwSandRepository;
    private final UpbitTickKrwSrmRepository upbitTickKrwSrmRepository;
    private final UpbitTickKrwXrpRepository upbitTickKrwXrpRepository;

    public UpbitTickRepository getRepositoryFromCode(UpbitCoinCode code) {
        switch (code) {
            case KRW_ADA:
                return upbitTickKrwAdaRepository;
            case KRW_ATOM:
                return upbitTickKrwAtomRepository;
            case KRW_AVAX:
                return upbitTickKrwAvaxRepository;
            case KRW_AXS:
                return upbitTickKrwAxsRepository;
            case KRW_BAT:
                return upbitTickKrwBatRepository;
            case KRW_BCH:
                return upbitTickKrwBchRepository;
            case KRW_BTC:
                return upbitTickKrwBtcRepository;
            case KRW_BTG:
                return upbitTickKrwBtgRepository;
            case KRW_CHZ:
                return upbitTickKrwChzRepository;
            case KRW_DOGE:
                return upbitTickKrwDogeRepository;
            case KRW_DOT:
                return upbitTickKrwDotRepository;
            case KRW_ENJ:
                return upbitTickKrwEnjRepository;
            case KRW_ETH:
                return upbitTickKrwEthRepository;
            case KRW_ETC:
                return upbitTickKrwEtcRepository;
            case KRW_FLOW:
                return upbitTickKrwFlowRepository;
            case KRW_MANA:
                return upbitTickKrwManaRepository;
            case KRW_MATIC:
                return upbitTickKrwMaticRepository;
            case KRW_PLA:
                return upbitTickKrwPlaRepository;
            case KRW_SAND:
                return upbitTickKrwSandRepository;
            case KRW_SRM:
                return upbitTickKrwSrmRepository;
            case KRW_STX:
                return upbitTickKrwStxRepository;
            case KRW_SOL:
                return upbitTickKrwSolRepository;
            case KRW_XRP:
                return upbitTickKrwXrpRepository;
            default:
                log.error("UpbitTickRespositoryPicker.getRepositoryFromCode , when code :  {}", code);
                throw new IllegalStateException("UpbitTickRespositoryPicker.getRepositoryFromCode , when code :  {}"+ code);
        }
    }

}
