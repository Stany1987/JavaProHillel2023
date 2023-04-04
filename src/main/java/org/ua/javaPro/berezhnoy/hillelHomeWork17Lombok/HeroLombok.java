package org.ua.javaPro.berezhnoy.hillelHomeWork17Lombok;

import lombok.*;
//Я так понял, что если анотация @Data то она заменяет Getter,Setter,ToString,Equals&HasCode и конструктор .
//Поэтому нет смысла их писать
@Data
public class HeroLombok {

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

