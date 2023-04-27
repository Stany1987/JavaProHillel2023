package org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns;

import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.Hero;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDao;

import java.util.ArrayList;
import java.util.List;

public class HeroService {

    private final HeroDao heroDao;
    private final HeroMovieService heroMovieService;

    public HeroService(HeroDao heroDao, HeroMovieService heroMovieService) {
        this.heroDao = heroDao;
        this.heroMovieService = heroMovieService;
    }

    public List<HeroDto> getHeroes() {
        List<Hero> heroes = heroDao.findAll();
        List<HeroDto> heroDtos = new ArrayList<>();
        for (Hero hero : heroes) {
            List<String> movies = heroMovieService.getPlayedIn(hero.getName());
            HeroDto heroDto = HeroDto.builder()
                    .name(hero.getName())
                    .movies(movies)
                    .build();
            heroDtos.add(heroDto);
        }
        return heroDtos;
    }

}
