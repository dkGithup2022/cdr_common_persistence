package com.dk0124.cdr;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootApplication
//@EntityScan({"com.dk0124.cdr.entity.upbit","com.dk0124.cdr.entity.bithumb"})
@ActiveProfiles("docker")
@TestPropertySource(locations="classpath:application.yml")
public class InitializeSpring {

    public static void main(String[] args) {
        SpringApplication.run(InitializeSpring.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}


/*
TODO : DATAJPATEST 어노테이션 사용 시, 읽어오는 yml 파일 위치가 이상해서 springboottest 로 통일함
TODO : test yml 파일에서 docker & container 로 나눠서 적용함.
TODO : docker 는 루트에 있는 pg docker 실행하는 sh 파일에 대해 시행
TODO : container 는 테스트 컨테이너 사용 .



@Target(value=TYPE)
 @Retention(value=RUNTIME)
 @Documented
 @Inherited
 @BootstrapWith(value=SpringBootTestContextBootstrapper.class)
 @ExtendWith(value=org.springframework.test.context.junit.jupiter.SpringExtension.class)
public @interface SpringBootTest
Annotation that can be specified on a test class that runs Spring Boot based tests. Provides the following features over and above the regular Spring TestContext Framework:
Uses SpringBootContextLoader as the default ContextLoader when no specific @ContextConfiguration(loader=...) is defined.
Automatically searches for a @SpringBootConfiguration when nested @Configuration is not used, and no explicit classes are specified.
Allows custom Environment properties to be defined using the properties attribute.
Allows application arguments to be defined using the args attribute.
Provides support for different webEnvironment modes, including the ability to start a fully running web server listening on a defined or random port.
Can register the following beans for web tests that are using a fully running web server:

TestRestTemplate
WebTestClient
HttpGraphQlTester



@Target(value=TYPE)
 @Retention(value=RUNTIME)
 @Documented
 @Inherited
 @BootstrapWith(value=org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTestContextBootstrapper.class)
 @ExtendWith(value=org.springframework.test.context.junit.jupiter.SpringExtension.class)
 @OverrideAutoConfiguration(enabled=false)
 @TypeExcludeFilters(value=DataJpaTypeExcludeFilter.class)
 @Transactional
 @AutoConfigureCache
 @AutoConfigureDataJpa
 @AutoConfigureTestDatabase
 @AutoConfigureTestEntityManager
 @ImportAutoConfiguration
public @interface DataJpaTest
Annotation for a JPA test that focuses only on JPA components.
Using this annotation will disable full auto-configuration and instead apply only configuration relevant to JPA tests.

By default, tests annotated with @DataJpaTest are transactional and roll back at the end of each test. They also use an embedded in-memory database (replacing any explicit or usually auto-configured DataSource). The @AutoConfigureTestDatabase annotation can be used to override these settings.

SQL queries are logged by default by setting the spring.jpa.show-sql property to true. This can be disabled using the showSql attribute.

If you are looking to load your full application configuration, but use an embedded database, you should consider @SpringBootTest combined with @AutoConfigureTestDatabase rather than this annotation.

When using JUnit 4, this annotation should be used in combination with @RunWith(SpringRunner.class).

Since:




-> 내일 할 일 : data jpa test 내용을 springboottest 호 변경  & 태그 생성

 */