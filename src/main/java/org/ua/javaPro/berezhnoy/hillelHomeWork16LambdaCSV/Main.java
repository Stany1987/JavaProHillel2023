package org.ua.javaPro.berezhnoy.hillelHomeWork16LambdaCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String line = "";
        List<Hero> heroes = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader
                ("src/main/resources/heroes_information.csv"))) {
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] heroData = line.substring(line.indexOf(";") + 1).split(";");


                Hero hero = new Hero(heroData[0], heroData[1], heroData[2], heroData[3], heroData[4],
                        Double.parseDouble(heroData[5].replace(',', '.')),
                        heroData[6], heroData[7], heroData[8], Integer.parseInt(heroData[9]));

                heroes.add(hero);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        printStatistics(heroes);

    }

    public static void printStatistics(List<Hero> heroes) {
        System.out.println("Average height: " + SolutionHero.heroesAverageHeight(heroes));
        System.out.println("Tallest hero: " + SolutionHero.tallestHeroName(heroes));
        System.out.println("Heaviest hero: " + SolutionHero.heaviestHero(heroes));
        System.out.println("Quantity of heroes by gender: " + SolutionHero.quantityGenderHeroes(heroes));
        System.out.println("Number of individuals in each alignment group: "
                + SolutionHero.numberIndividualsInEachGroup(heroes));
        System.out.println("Five most popular publisher titles: " + SolutionHero.fiveMostPopularPublisherTitles(heroes));
        System.out.println("Top hair colors: " + SolutionHero.topHairColors(heroes));
        System.out.println("Top eye colors: " + SolutionHero.topColorsEyes(heroes));
    }


}
