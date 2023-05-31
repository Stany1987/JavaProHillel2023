package org.ua.javaPro.berezhnoy.bank.hillelHomwWork28DBVersioning;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "persons")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String uid;
    private String name;
    private String email;


    @OneToMany(mappedBy = "person")
    private List<Account> accounts;

}
