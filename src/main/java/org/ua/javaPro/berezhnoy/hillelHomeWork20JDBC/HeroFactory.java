package org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC;

import javax.sql.DataSource;

public class HeroFactory {
    public static HeroService createService(DataSource dataSource) {
        return new HeroService(createDao(dataSource));
    }

    private static HeroDao createDao(DataSource dataSource) {
        return new HeroDaoImp(dataSource);
    }

}
