package org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;


public class Main {


    public static void main(String[] args) {

        Hero hero = new Hero(734, "princess java", "female", "blue", "human", "dlack",
                170.8, "wino", "red", "good", 40);
        var dataSource = dataSource();
        var service = HeroFactory.createService(dataSource);
        service.findAll().forEach(System.out::println);
        service.createHero(hero);
        System.out.println(service.findByName("princess java"));

        service.updateHero(hero);
        service.deleteHero(734L);
    }

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("postgres");
        ds.setUser("postgres");
        ds.setPassword("postgres");
        ds.setCurrentSchema("hilleljdbc");
        return ds;
    }
}
