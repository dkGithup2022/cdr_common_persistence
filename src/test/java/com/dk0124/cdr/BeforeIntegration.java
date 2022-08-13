package com.dk0124.cdr;


import com.dk0124.cdr.app.tags.IntegrationWithContainer;
import com.dk0124.cdr.app.tags.IntegrationWithoutContainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@IntegrationWithoutContainer
public class BeforeIntegration {

    @Autowired
    ModelMapper modelMapper;

    @Test
    @DisplayName("통합 테스트 환경 확인 : 빈 주입")
    void checkBean(){
        assertNotNull(modelMapper);
    }
}
