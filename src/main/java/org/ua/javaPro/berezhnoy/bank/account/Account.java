package org.ua.javaPro.berezhnoy.bank.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.ua.javaPro.berezhnoy.bank.person.Person;
import org.ua.javaPro.berezhnoy.bank.transaction.Transaction;

import java.util.List;

    @Entity
    @Table(name = "accounts")
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public class Account {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(unique = true)
        private String uid;
        private String iban;
        private Long balance;
        @ManyToOne
        @JoinColumn(name = "person_id", referencedColumnName = "id")
        @ToString.Exclude
        private Person person;
        @Column(nullable = false)
        private String currency;

        @OneToMany(mappedBy = "fromAccount")
        @ToString.Exclude
        private List<Transaction> outgoingTransactions;

        @OneToMany(mappedBy = "toAccount")
        @ToString.Exclude
        private List<Transaction> incomingTransactions;
    }
