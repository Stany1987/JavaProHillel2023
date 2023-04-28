package org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns;

import lombok.RequiredArgsConstructor;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.Hero;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDao;

import java.util.List;

@RequiredArgsConstructor
public class DummyHeroDao implements HeroDao {
    private final List<Hero> heroes;

    @Override
    public List<Hero> findAll() {
        return heroes;
    }

    @Override
    public List<Hero> findByName(String name) {
        return heroes.stream()
                .filter(hero -> hero.getName().equals(name))
                .toList();
    }

    @Override
    public void create(Hero hero) {
        heroes.add(hero);
    }

    @Override
    public void update(Hero hero) {
        heroes.set((int) hero.getId(), hero);
    }

    @Override
    public boolean delete(Long id) {
        return heroes.remove(heroes.get(Math.toIntExact(id)));
    }
}
