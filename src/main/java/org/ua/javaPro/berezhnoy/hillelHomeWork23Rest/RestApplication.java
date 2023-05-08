package org.ua.javaPro.berezhnoy.hillelHomeWork23Rest;


import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroFactory;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroService;

import javax.sql.DataSource;

@SpringBootApplication

public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public HeroService heroService() {
        return HeroFactory.createService(dataSource());
    }

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setUrl("jdbc:postgresql://localhost:5432/postgres");
        ds.setDatabaseName("postgres");
        ds.setUser("postgres");
        ds.setPassword("postgres");
        ds.setCurrentSchema("hilleljdbc");
        return ds;
    }
}


