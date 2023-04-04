package org.ua.javaPro.berezhnoy.hillelHomeWork16LambdaCSV;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SolutionHero {

    public static double heroesAverageHeight(List<Hero> height) {
        return height.stream()
                .filter(hero -> hero.height() > 0)
                .mapToDouble(Hero::height)
                .average()
                .orElse(0);
    }

    public static String tallestHeroName(List<Hero> tallest) {
        return tallest.stream()
                .max(Comparator.comparingDouble(Hero::height))
                .map(Hero::name)
                .orElse("");
    }


    public static String heaviestHero(List<Hero> weight) {
        return weight.stream()
                .max(Comparator.comparing(Hero::weight))
                .map(Hero::name)
                .orElse("");

    }

    public static Map<String, Long> quantityGenderHeroes(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::gender, Collectors.counting()));

    }

    public static Map<String, Long> numberIndividualsInEachGroup(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::alignment, Collectors.counting()));
    }

    public static List<String> fiveMostPopularPublisherTitles(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(Hero::publisher, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topHairColors(List<Hero> heroes) {
        return heroes.stream()
                .filter(hero -> !hero.hairColor().equals("No Hair") && !hero.hairColor().equals("-"))
                .collect(Collectors.groupingBy(Hero::hairColor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> topColorsEyes(List<Hero> heroes) {
        return heroes.stream()
                .filter(hero -> hero.eyeColor() != null)
                .collect(Collectors.groupingBy(Hero::eyeColor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
