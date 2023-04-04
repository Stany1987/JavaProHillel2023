package org.ua.javaPro.berezhnoy.hillelHomeWork17Lombok;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroLombokTest {
    @Test
    void testGetAndSetHero() {
        HeroLombok hero = new HeroLombok();
        hero.setName("Destroyer");
        hero.setGender("Male");
        hero.setEyeColor("Red");
        hero.setRace("Orc");
        hero.setHairColor("Black");
        hero.setHeight(230.7);
        hero.setPublisher("Lineage");
        hero.setSkinColor("Green");
        hero.setAlignment("Bad");
        hero.setWeight(175);
//Не хотел писать много Assert , решил попробовать так.
        List<?> listExpect = List.of("Destroyer", "Male", "Red", "Orc", "Black", 230.7, "Lineage", "Green", "Bad", 175);
        List<?> heroGet = List.of(hero.getName(), hero.getGender(), hero.getEyeColor(), hero.getRace(),
                hero.getHairColor(), hero.getHeight(), hero.getPublisher(), hero.getSkinColor(), hero.getAlignment(),
                hero.getWeight());
        assertEquals(listExpect, heroGet);
    }

}