package com.dk0124.cdr.repositoryUtils.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.candle.BithumbCandleDto;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandle;
import com.dk0124.cdr.persistence.entity.bithumb.candle.BithumbCandleUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbCandleMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository.BithumbCandleRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbCandleRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationWithContainer
class BithumbCandleRepositoryUtilsTest {
    @Autowired
    BithumbCandleRepositoryUtils bithumbCandleRepositoryUtils;

    @Test
    public void empty(){assertNotNull(bithumbCandleRepositoryUtils);}

    @ParameterizedTest()
    @DisplayName("BithumbCandleRepositoryUtils.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_all_bithumb_codes")
    public void get_repository_from_code(BithumbCoinCode code){
        BithumbCandleRepository repo = bithumbCandleRepositoryUtils.getRepositoryFromCode(code);
        assertNotNull(repo);
    }

    @ParameterizedTest()
    @DisplayName("BithumbCandleRepositoryUtils.getRepositoryFromCode(String code) 테스트")
    @MethodSource("get_all_bithumb_codes")
    public void get_repository_from_code_string(BithumbCoinCode code){
        BithumbCandleRepository repo = bithumbCandleRepositoryUtils.getRepositoryFromCode(code.toString());
        assertNotNull(repo);
    }

    static Stream<Arguments> get_all_bithumb_codes() {
       return Arrays.stream(BithumbCoinCode.values()).map(c -> Arguments.of(c));
    }
}