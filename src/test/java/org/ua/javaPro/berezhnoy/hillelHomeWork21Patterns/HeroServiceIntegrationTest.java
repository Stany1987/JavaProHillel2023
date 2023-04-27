package org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns;

import org.junit.jupiter.api.Test;
import org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC.Hero;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroServiceIntegrationTest {
    private HeroService target = HeroFabric.createService(List.of(Hero.builder().name("Batman").build(),
            Hero.builder().name("Dead Pool").build()));

    @Test
    void testIsNotEmpty() {
        List<HeroDto> heroes = target.getHeroes();
        assertFalse(heroes.isEmpty());
    }

    @Test
    void testHeroSize() {
        List<HeroDto> heroes = target.getHeroes();
        assertEquals(2, heroes.size());
    }

}