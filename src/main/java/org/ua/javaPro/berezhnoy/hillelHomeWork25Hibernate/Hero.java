package org.ua.javaPro.berezhnoy.hillelHomeWork25Hibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "heroes")

public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;
    @Column(name = "eye_color ")
    private String eyeColor;
    private String race;
    @Column(name = "hair_color")
    private String hairColor;
    private Double height;
    private String publisher;
    @Column(name = "skin_color")
    private String skinColor;
    @Column(name = "aligment")
    private String alignment;
    private Integer weight;

}
