package com.dk0124.cdr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootApplication
@EntityScan({"com.dk0124.cdr.entity.upbit","com.dk0124.cdr.entity.bithumb"})
@TestPropertySource(locations="classpath:application-test.properties")
@ActiveProfiles("test")
public class InitializeSpring {
    public static void main(String[] args) {
        SpringApplication.run(InitializeSpring.class, args);
    }
}
