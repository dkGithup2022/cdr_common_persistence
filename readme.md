#cdr_common_persistence
  이 모듈은 cdr 프로젝트에서 공용으로 사용할 persistence layer의 클래스들을 제공합니다.
  업비트 코인 23 개에 대한 캔들,거래내역, 오더북과 빘썸 21개 코인에 대한 거래내역, 캔들, 오더북 데이터를 수급
  총 140 여개의 테이블과 그에 대한 Dto, repository 클래스가 제공됨.
  type safe 한 repository 사용을 위한 Repository picker 클래스가 제공됨. 사용법은 README 혹은 test 코드 참고 

###목차
 1. 제공 기능
 2. 패키지
 3. 테스트


### 제공 기능 
1. entity 
2. dto 
3. mapper 
4. jpa repository 
5. jpa repository picker

#### entity 
jpa entity 클래스를 정의함. 
  vender 사, 코인 종류, 데이터 종류별로 구분한 테이블의 구조 
자세한 내용은  이 링크로 : https://www.notion.so/1091f39112244ad9b746e18df6868960

주의점  : 지금 code 의 타입이 String 으로 되어 있는데, 만약에 CoinCode enum 으로 바꾸는게 더 적절한거 같으면 김도현한테 연락.
이거 나도 햇갈림 ( 김도현)
#### dto
dto 클래스, 코인 종류별로 데이터를 구분 하지 않음 .
#### mapper 
dto 오브젝트를 entity 로 변환.
jpa repository 에서 사용하기 전에 변환 하는 것이 권장됨
dto 는 코인 별 구분이 없지만 mapper 의 결과로 코인 종류가 구분된 타입의 데이터가 리턴됨 .
만약 올바르지 않은 CODE 값을 DTO 가 갖고 있다면 mapper 혹은 entityFactory 코드에서 IllegalArgumentException 을 반환 

      void map_candle_with_valid_input() throws JsonProcessingException {
        UpbitOrderbookDto dto = objectMapper.readValue(sampleOrderbookString,UpbitOrderbookDto.class);
        dto.setCode("KRW-BTC");
        UpbitOrderbook orderbook = upbitOrderbookMapper.mapOrderbook(dto);
        assert orderbook instanceof UpbitOrderbook;       // true
        assert orderbook instanceof UpbitOrderbookKrwBtc; // true
    }
    
#### jpa repository
entity 에 대한 jpa 레포지토리 

#### repositoryPicker
입력받은 CoinCode 에 맞는 repository 를 반환함. 

    @ParameterizedTest()
    @DisplayName("UpbitCandleRepositoryPicker.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_each_typed_upbit_candles")
    void getRepositoryFromCode(UpbitCandle c){
        UpbitCandleCommonJpaInterface repository = upbitTickRepositoryPicker.getRepositoryFromCode(UpbitCoinCode.fromString(c.getMarket()));
        UpbitCandle saved = repository.save(c);
        assertNotNull(saved);
        assertEquals(c.getClass(),saved.getClass());
    }


###패키지
src

