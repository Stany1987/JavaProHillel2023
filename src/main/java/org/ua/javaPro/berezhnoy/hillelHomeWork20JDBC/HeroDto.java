package org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC;

public record HeroDto(long id, String name, String gender, String eyeColor, String race, String hairColor,
                      double height,
                      String publisher, String skinColor, String alignment, int weight) {

    public static HeroDto from(Hero hero) {
        return new HeroDto(hero.getId(), hero.getName(), hero.getGender(), hero.getEyeColor(), hero.getRace(),
                hero.getHairColor(), hero.getHeight(), hero.getPublisher(), hero.getSkinColor(), hero.getAlignment(),
                hero.getWeight());
    }

    public Hero toEntity() {
        return new Hero(
                this.id(),
                this.name(),
                this.gender(),
                this.eyeColor(),
                this.race(),
                this.hairColor(),
                this.height(),
                this.publisher(),
                this.skinColor(),
                this.alignment(),
                this.weight()
        );
    }
}
