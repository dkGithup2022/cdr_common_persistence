package com.dk0124.cdr.repositoryUtils.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.dto.bithumb.orderbook.BithumbOrderbookDto;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbook;
import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbookUtils;
import com.dk0124.cdr.persistence.mapper.bithumb.BithumbOrderbookMapper;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbCandleRepository.BithumbCandleRepository;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbOrderbookRepository.BithumbOrderbookRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbCandleRepositoryUtils;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbOrderbookRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationWithContainer
class BithumbOrderbookRepositoryUtilsTest {
    @Autowired
    BithumbOrderbookRepositoryUtils bithumbOrderbookRepositoryUtils;

    @Test
    public void empty(){assertNotNull(bithumbOrderbookRepositoryUtils);}

    @ParameterizedTest()
    @DisplayName("BithumbOrderbookRepositoryUtils.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_all_bithumb_codes")
    public void get_repository_from_code(BithumbCoinCode code){
        BithumbOrderbookRepository repo = bithumbOrderbookRepositoryUtils.getRepositoryFromCode(code);
        assertNotNull(repo);
    }

    @ParameterizedTest()
    @DisplayName("BithumbCandleRepositoryUtils.getRepositoryFromCode(String code) 테스트")
    @MethodSource("get_all_bithumb_codes")
    public void get_repository_from_code_string(BithumbCoinCode code){
        BithumbOrderbookRepository repo = bithumbOrderbookRepositoryUtils.getRepositoryFromCode(code.toString());
        assertNotNull(repo);
    }

    static Stream<Arguments> get_all_bithumb_codes() {
        return Arrays.stream(BithumbCoinCode.values()).map(c -> Arguments.of(c));
    }

}