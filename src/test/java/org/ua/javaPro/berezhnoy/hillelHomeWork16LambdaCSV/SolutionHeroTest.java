package org.ua.javaPro.berezhnoy.hillelHomeWork16LambdaCSV;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionHeroTest {
    List<Hero> heroes = new ArrayList<>(Arrays.asList(
            new Hero("Batman", "Male", "blue", "Human", "black", 188.0,
                    "DC Comics", "-", "bad", 95),
            new Hero("Superman", "Male", "blue", "Kryptonian", "black", 191.0,
                    "DC Comics", "pale", "good", 101),
            new Hero("Wonder Woman", "Female", "blue", "Amazon", "black", 183.0,
                    "DC Comics", "pale", "good", 74),
            new Hero("Flash", "Male", "green", "Human", "blond", 180.0,
                    "DC Comics", "-", "bad", 81),
            new Hero("Hulk", "Male", "green", "Human", "green", 244.0,
                    "Marvel Comics", "green", "good", 630),
            new Hero("Spider-Man", "Male", "hazel", "Human", "brown", 178.0,
                    "Marvel Comics", "-", "bad", 74),
            new Hero("Iron Man", "Male", "blue", "Human", "black", 198.0,
                    "Marvel Comics", "-", "good", 191),
            new Hero("Captain America", "Male", "blue", "Human", "blond", 188.0,
                    "Marvel Comics", "fair", "good", 108),
            new Hero("Black Widow", "Female", "green", "Human", "red", 170.0,
                    "Marvel Comics", "-", "good", 59),
            new Hero("Thor", "Male", "blue", "Asgardian", "blond", 198.0,
                    "Marvel Comics", "blue", "good", 290),
            new Hero("Abe Sapien", "Male", "blue", "Icthyo Sapien", "No Hair", 191,
                    "Dark Horse Comics", "blue", "good", 65),
            new Hero("Alex Mercer", "Male", "-", "Human", "-", -99, "Wildstorm",
                    "-", "bad", -99),
            new Hero("Alien;Male", "-", "Xenomorph XX121", "No Hair", "No Hair", 244,
                    "Space", "black", "bad", 169)
    ));

    @Test
    void testAverageHeight() {
        assertEquals(196.08333333333334, SolutionHero.heroesAverageHeight(heroes));
    }

    @Test
    void testTallestHeroName() {
        assertEquals("Hulk", SolutionHero.tallestHeroName(heroes));
    }

    @Test
    void testHeaviestHero() {
        assertEquals("Hulk", SolutionHero.heaviestHero(heroes));
    }

    @Test
    void testQuantityGenderHeroes() {
        assertEquals(10, SolutionHero.quantityGenderHeroes(heroes).get("Male"));
        assertEquals(2, SolutionHero.quantityGenderHeroes(heroes).get("Female"));
        assertEquals(1, SolutionHero.quantityGenderHeroes(heroes).get("-"));
    }

    @Test
    void testNumberIndividualsInEachGroup() {
        assertEquals(8, SolutionHero.numberIndividualsInEachGroup(heroes).get("good"));
        assertEquals(5, SolutionHero.numberIndividualsInEachGroup(heroes).get("bad"));
    }

    @Test
    void testFiveMostPopularPublisherTitles() {
        assertEquals(Arrays.asList("Marvel Comics", "DC Comics", "Space", "Wildstorm", "Dark Horse Comics")
                , SolutionHero.fiveMostPopularPublisherTitles(heroes));
    }

    @Test
    void testTopHairColors() {
        assertEquals(Arrays.asList("black", "blond", "red"), SolutionHero.topHairColors(heroes));
    }

    @Test
    void testTopColorsEyes() {
        assertEquals(Arrays.asList("blue"), SolutionHero.topColorsEyes(heroes));
    }


}