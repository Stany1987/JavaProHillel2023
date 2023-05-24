package org.ua.javaPro.berezhnoy.bank.hillelHomeWork27DataJPA;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
@PropertySource("classpath:application.properties")
public class DataConfiguration {
    @Value("${spring.second-datasource.url}")
    private String secondUrl;

    @Value("${spring.datasource.databasename}")
    private String secondDatabaseName;

    @Value("${spring.second-datasource.username}")
    private String secondUserNAme;

    @Value("${spring.second-datasource.password}")
    private String secondPassword;

    @Bean
    public DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setUrl(secondUrl);
        ds.setDatabaseName(secondDatabaseName);
        ds.setUser(secondUserNAme);
        ds.setPassword(secondPassword);
        return ds;
    }
}
