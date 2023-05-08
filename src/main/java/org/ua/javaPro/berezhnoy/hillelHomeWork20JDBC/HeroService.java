package org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class HeroService {
    private final HeroDao dao;

    public List<HeroDto> findAll() {
        return dao.findAll().stream()
                .map(HeroDto::from)
                .toList();
    }


    public List<HeroDto> findByName(String name) {
        return dao.findByName(name).stream()
                .map(HeroDto::from)
                .toList();
    }

    public List<HeroDto> findById(long id) {
        return dao.findById(id).stream()
                .map(HeroDto::from)
                .toList();
    }

    public HeroDto createHero(Hero hero) {
        dao.create(hero);
        return HeroDto.from(hero);
    }

    public void updateHero(Hero hero) {
        dao.update(hero);
    }

    public boolean deleteHero(Long id) {
        return dao.delete(id);
    }
}
