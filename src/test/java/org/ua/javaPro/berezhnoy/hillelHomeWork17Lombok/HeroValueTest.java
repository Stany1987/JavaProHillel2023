package org.ua.javaPro.berezhnoy.hillelHomeWork17Lombok;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroValueTest {
    @Test
    void testHeroValue() {
        HeroValue hero = new HeroValue("Destroyer", "Male", "Red", "Orc", "Black",
                230.7, "Lineage", "Green", "Bad", 175);
        List<?> listExpect = List.of("Destroyer", "Male", "Red", "Orc", "Black", 230.7, "Lineage", "Green", "Bad", 175);
        List<?> heroGet = List.of(hero.getName(), hero.getGender(), hero.getEyeColor(), hero.getRace(),
                hero.getHairColor(), hero.getHeight(), hero.getPublisher(), hero.getSkinColor(), hero.getAlignment(),
                hero.getWeight());

        assertEquals(listExpect, heroGet);
    }
}