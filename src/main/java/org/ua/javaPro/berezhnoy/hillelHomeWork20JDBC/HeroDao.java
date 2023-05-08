package org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC;

import java.util.List;

public interface HeroDao {
    List<Hero> findAll();

    List<Hero> findByName(String name);

    List<Hero> findById(long id);


    void create(Hero hero);

    void update(Hero hero);

    boolean delete(Long id);

}
