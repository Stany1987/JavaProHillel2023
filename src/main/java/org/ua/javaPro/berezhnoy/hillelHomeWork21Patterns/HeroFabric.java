package org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns;

import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.Hero;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDao;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDaoImp;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

public class HeroFabric {
    public HeroService createService(DataSource dataSource) {
        return new HeroService(createDao(dataSource), new HeroMovieService(new HashMap<>()));
    }

    private static HeroDao createDao(DataSource dataSource) {
        return new HeroDaoImp(dataSource);
    }


    public static HeroService createService(List<Hero> heroes) {
        return new HeroService(new DummyHeroDao(heroes), new HeroMovieService(new HashMap<>()));
    }
}
