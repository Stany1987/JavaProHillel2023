package org.ua.javaPro.berezhnoy.hillelHomeWork17Lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
public class HeroBuilder {


    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String alignment;
    private int weight;

}
