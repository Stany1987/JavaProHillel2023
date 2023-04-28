package org.ua.javaPro.berezhnoy.hillelHomeWork21Patterns;

import java.util.List;

public class HeroDto {
    private String name;
    private List<String> movies;

    public HeroDto(String name, List<String> movies) {
        this.name = name;
        this.movies = movies;
    }

    public static HeroBuild builder() {
        return new HeroBuild();
    }

    public static class HeroBuild {
        private String name;
        private List<String> movies;

        public HeroBuild name(String name) {
            this.name = name;
            return this;
        }

        public HeroBuild movies(List<String> movies) {
            this.movies = movies;
            return this;
        }

        public HeroDto build() {
            return new HeroDto(name, movies);
        }

    }
}
