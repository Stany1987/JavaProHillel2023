package org.ua.javaPro.berezhnoy.hillelHomeWork24SpringCore;

import org.postgresql.ds.PGSimpleDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDaoImp;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroService;
import org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns.HeroMovieService;

import javax.sql.DataSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroFactory.createService;

@Configuration
@ComponentScan("org.ua.javaPro.hillelHomeWork24SpringCore")
@PropertySource("classpath:application.properties")
public class HeroConfiguration {

    @Value("${spring.datasource.url}")
    private String url;

    @Value
            ("${spring.datasource.databasename}")
    private String databaseName;

    @Value("${spring.datasource.username}")
    private String userNAme;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HeroService heroService(DataSource dataSource) {
        return createService(dataSource);
    }

    @Bean
    public HeroDaoImp heroDaoImp(DataSource dataSource) {
        return new HeroDaoImp(dataSource);
    }


    @Bean
    public DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setUrl(url);
        ds.setDatabaseName(databaseName);
        ds.setUser(userNAme);
        ds.setPassword(password);
        ds.setCurrentSchema("hilleljdbc");
        return ds;
    }

    @Bean
    public HeroMovieService heroMovieService() {
        Map<String, List<String>> movieHero = new HashMap<>();
        return new HeroMovieService(movieHero);
    }

}

