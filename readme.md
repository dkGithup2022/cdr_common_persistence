# CDR-API-PERSISTENCE

 <img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=flat&logo=SpringBoot&logoColor=white"/>
 <img src="https://img.shields.io/badge/JPA-6DB33F?style=flat&logo=SpringBoot&logoColor=white"/>


위의 데이터들, 132 개 테이블에 대한 persistence layer 공통 코드에 대한 모듈입니다.

## entity & dto
* vendor type: upbit, bithumb 
* data type: ticks, orderbook, candles
* code 
  * bithumb : [KRW-BTC, KRW-XRP, KRW-ETH, KRW-STX, KRW-SOL, KRW-ADA, KRW-DOT, KRW-BCH, KRW-BAT, KRW-AVAX, KRW-ETC, KRW-AXS, KRW-PLA, KRW-SAND, KRW-SRM, KRW-DOGE, KRW-MANA, KRW-FLOW, KRW-BTG, KRW-ATOM, KRW-MATIC, KRW-ENJ, KRW-CHZ]
  * upbit : [BTC_KRW, XRP_KRW, ETH_KRW, SOL_KRW, ADA_KRW, DOT_KRW, BCH_KRW, BAT_KRW, AVAX_KRW, ETC_KRW, AXS_KRW, PLA_KRW, SAND_KRW, SRM_KRW, DOGE_KRW, MANA_KRW, BTG_KRW, ATOM_KRW, MATIC_KRW, ENJ_KRW, CHZ_KRW]

각 코드에 대한 클래스의 추상화 클래스를 각 entity.vendor.dataType 패키지의 상위에서 제공합니다. 추상화 클래스로 변환은 해당 패키지 위치의 UTILS클래스에서 제공함.

## repositoryUtils
String code, CoinCode code 를 입력받아, 해당 코드에 맞는 Repository interface 를 리턴합니다. 위의 {data}Utils 에서 추상화된 데이터 클래스 사용 시 사용할 수 있습니다.

테스트 코드 작성이 어려운 구조라 수정 예정에 있습니다. 

예시)
```
package repository.bithumbCandleRepository.BithumbCandleTest

@Test
void get_repository_from_code_and_save(BithumbCandle c) {
  BithumbCandleRepository repository =
      bithumbCandleRepositoryUtils.getRepositoryFromCode(c.getCode());
  BithumbCandle saved = repository.save(c);
}
```

##
