package com.example.productmicroservice.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
public class DBconfig {

    @Bean
    public BasicDataSource getData() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        basicDataSource.setPassword("westside");
        basicDataSource.setUsername("postgres");
        return basicDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(BasicDataSource basicDataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(basicDataSource);
        return jdbcTemplate;
    }
}