package org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class HeroMovieService {
    private final Map<String, List<String>> heroMoviesMap;

    public HeroMovieService(Map<String, List<String>> heroMoviesMap) {
        this.heroMoviesMap = heroMoviesMap;
    }

    public List<String> getPlayedIn(String heroName) {
        return heroMoviesMap.entrySet().stream()
                .filter(entry -> entry.getKey().equals(heroName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(Collections.emptyList());
    }

}
