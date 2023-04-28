package org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.Hero;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.HeroDao;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HeroServiceTest {
    @Mock
    private HeroDao heroDao;
    @Mock
    private HeroMovieService heroMovieService;

    @InjectMocks
    private HeroService heroService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        heroService = new HeroService(heroDao, heroMovieService);
    }

    @Test
    public void testHeroS() {
        List<Hero> heroes = List.of(Hero.builder().name("Wade Wilson").build(), Hero.builder().name("Batman").build());

        when(heroDao.findAll()).thenReturn(heroes);
        List<HeroDto> heroDtos = heroService.getHeroes();
        assertEquals(2, heroDtos.size());
    }
}