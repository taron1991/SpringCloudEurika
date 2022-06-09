package com.restful.restproject.otherConfigs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.restful.restproject")
public class ConfigurationClass {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
