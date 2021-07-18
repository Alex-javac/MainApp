package com.mastery.java.task.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DataBaseConfig {

    @Value("${db.url}")
    private  String URL_KEY ;
    @Value("${db.username}")
    private String USERNAME_KEY;
    @Value("${db.password}")
    private String PASSWORD_KEY;


    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(URL_KEY+"?stringtype=unspecified");
        dataSource.setUsername(USERNAME_KEY);
        dataSource.setPassword(PASSWORD_KEY);
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(){
        Resource resource = new ClassPathResource("scriptSQL.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.execute(dataSource());
        return new JdbcTemplate(dataSource());
    }
}
