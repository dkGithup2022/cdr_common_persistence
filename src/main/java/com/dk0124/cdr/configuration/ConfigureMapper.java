package com.dk0124.cdr.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureMapper {
    @Bean
    @ConditionalOnMissingBean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
