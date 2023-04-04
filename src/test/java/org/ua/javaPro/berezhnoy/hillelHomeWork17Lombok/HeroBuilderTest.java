package org.ua.javaPro.berezhnoy.hillelHomeWork17Lombok;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeroBuilderTest {

    @Test
    void testHeroBuild() {
        HeroBuilder hero = HeroBuilder.builder()
                .name("Destroyer")
                .gender("Male")
                .eyeColor("Red")
                .race("Orc")
                .hairColor("Black")
                .height(230.7)
                .publisher("Lineage")
                .skinColor("Green")
                .alignment("Bad")
                .weight(175)
                .build();

        List<?> listExpect = List.of("Destroyer", "Male", "Red", "Orc", "Black", 230.7, "Lineage", "Green", "Bad", 175);
        List<?> heroGetBuild = List.of(hero.getName(), hero.getGender(), hero.getEyeColor(), hero.getRace(),
                hero.getHairColor(), hero.getHeight(), hero.getPublisher(), hero.getSkinColor(), hero.getAlignment(),
                hero.getWeight());
        assertEquals(listExpect, heroGetBuild);

    }

}