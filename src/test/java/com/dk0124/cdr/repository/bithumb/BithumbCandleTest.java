package com.dk0124.cdr.repository.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.candle.BithumbCandleDto;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandleUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbCandleMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository.BithumbCandleRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbCandleRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

@IntegrationWithContainer
public class BithumbCandleTest {
    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    BithumbCandleRepositoryUtils bithumbCandleRepositoryUtils;

    @Autowired
    BithumbCandleMapper bithumbCandleMapper;
    @Test
    public void empty(){

    }

    @Test
    @DisplayName("repository test : 빗썸 캔들 저장 ")
    void save_BithumbCandle(){
        //given

        //when

        //then
    }

    @Test
    @DisplayName("repository test : 빗썸 캔들 검색 ")
    void find_One_Bithumb_Candle_By_Id(){
        //given

        //when

        //then
    }

    @Test
    @DisplayName("repository test : 빗썸 캔들 검색 ")
    void find_One_Bithumb_Candle_creation_query(){
        //given
        for(int i = 0; i<1000 ; i++){
            BithumbCandleDto  dto = BithumbCandleDto.builder()
                    .code(BithumbCoinCode.KRW_ADA.toString())
                    .timestamp(Long.valueOf(i))
                    .build();
            BithumbCandleRepository repo =
                    bithumbCandleRepositoryUtils.getRepositoryFromCode(BithumbCoinCode.fromString(dto.getCode()));
            repo.save(BithumbCandleUtils.of(bithumbCandleMapper.mapCandle(dto)));
        }
        //when




        //then
    }
}
