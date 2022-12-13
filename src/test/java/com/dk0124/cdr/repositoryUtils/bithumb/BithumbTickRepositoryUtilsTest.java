package com.dk0124.cdr.repositoryUtils.bithumb;

import com.dk0124.cdr.constants.coinCode.bithumbCoinCode.BithumbCoinCode;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTick;
import com.dk0124.cdr.persistence.entity.bithumb.tick.BithumbTickUtils;
import com.dk0124.cdr.persistence.repository.bithumb.bithumbTickRepository.BithumbTickRepository;
import com.dk0124.cdr.persistence.repositoryUtils.bithumb.BithumbTickRepositoryUtils;
import com.dk0124.cdr.tags.IntegrationWithContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@IntegrationWithContainer
class BithumbTickRepositoryUtilsTest {

    @Autowired
    BithumbTickRepositoryUtils bithumbTickRepositoryUtils;

    @Test
    public void empty(){assertNotNull(bithumbTickRepositoryUtils);}

    @ParameterizedTest()
    @DisplayName("BithumbTickRepositoryUtils.getRepositoryFromCode(UpbitCoinCode code) 테스트")
    @MethodSource("get_all_bithumb_codes")
    public void get_repository_from_code(BithumbCoinCode code){
        BithumbTickRepository repo = bithumbTickRepositoryUtils.getRepositoryFromCode(code);
        assertNotNull(repo);
    }

    @ParameterizedTest()
    @DisplayName("BithumbTickRepositoryUtils.getRepositoryFromCode(String code) 테스트")
    @MethodSource("get_all_bithumb_codes")
    public void get_repository_from_code_string(BithumbCoinCode code){
        BithumbTickRepository repo = bithumbTickRepositoryUtils.getRepositoryFromCode(code.toString());
        assertNotNull(repo);
    }

    static Stream<Arguments> get_all_bithumb_codes() {
        return Arrays.stream(BithumbCoinCode.values()).map(c -> Arguments.of(c));
    }
}