package org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns;

import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDao;

import java.util.List;
import java.util.stream.Collectors;

public class HeroService {

    private final HeroDao heroDao;
    private final HeroMovieService heroMovieService;

    public HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;
    }

    public List<HeroDto> getHeroes() {
        return heroDao.findAll().stream()
                .map(hero -> HeroDto.builder()
                        .name(hero.getName())
                        .movies(heroMovieService.getPlayedIn(hero.getName()))
                        .build())
                .collect(Collectors.toList());
    }

}
