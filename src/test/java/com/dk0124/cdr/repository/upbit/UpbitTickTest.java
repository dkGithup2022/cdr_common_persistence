package com.dk0124.cdr.repository.upbit;

import com.dk0124.cdr.dto.upbit.tick.UpbitTickDto;
import com.dk0124.cdr.entity.upbit.tick.UpbitTick;
import com.dk0124.cdr.entity.upbit.tick.UpbitTickFactory;
import com.dk0124.cdr.entity.upbit.tick.coins.UpbitTickKrwDot;
import com.dk0124.cdr.repository.upbit.upbitTickRepository.UpbitTickKrwDotRepository;
import com.dk0124.cdr.app.tags.IntegrationWithContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationWithContainer
public class UpbitTickTest {

    @Container
    static PostgreSQLContainer container = new PostgreSQLContainer().withDatabaseName("studyTest");

    @Autowired
    UpbitTickKrwDotRepository upbitTickKrwDotRepository;

    ModelMapper mapper = new ModelMapper();

    @Test
    void empty(){ assertNotNull(upbitTickKrwDotRepository); }

    @Test
    @DisplayName("repository test : 업비트 틱 저장 ")
    void save_UpbitTick(){
        //given
        UpbitTickDto dto = UpbitTickDto
                .builder()
                .code("KRW-BTC").timestamp(1L)
                .build();

        UpbitTick entity = mapper.map(dto,UpbitTick.class);
        entity = UpbitTickFactory.of(entity);

        //when
        UpbitTick result = upbitTickKrwDotRepository.save(entity);

        //then
        System.out.println("first : " +  entity.toString());
        System.out.println("second: " + result.toString());
        assertNotNull(result);

    }

    @Test
    @DisplayName("repository test : 업비트 틱 검색 ")
    void find_One_UpbitTick_By_Id(){
        //given
        UpbitTickDto dto = UpbitTickDto
                .builder()
                .code("KRW-DOT").timestamp(1L)
                .build();

        UpbitTick entity = mapper.map(dto,UpbitTick.class);
        entity = UpbitTickFactory.of(entity);

        UpbitTick saved = upbitTickKrwDotRepository.save(entity);

        //when
        UpbitTick foundOne = upbitTickKrwDotRepository.findBySequentialId(saved.getSequentialId());

        //then
        assertEquals(foundOne.getSequentialId(), saved.getSequentialId());
    }

    @Test
    @DisplayName("saved 이후 리턴 타입 유지되는지 확인 ")
    void check_repository_save_return_type(){
        //given
        UpbitTickDto dto = UpbitTickDto
                .builder()
                .code("KRW-DOT").timestamp(1L)
                .build();

        UpbitTick entity = mapper.map(dto,UpbitTick.class);
        entity = UpbitTickFactory.of(entity);

        //when
        UpbitTick saved = upbitTickKrwDotRepository.save(entity);

        //then
        assert saved instanceof UpbitTickKrwDot;
        assert saved instanceof UpbitTick;
    }
}
