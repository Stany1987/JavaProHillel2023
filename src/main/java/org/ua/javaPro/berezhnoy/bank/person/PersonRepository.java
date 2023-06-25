package org.ua.javaPro.berezhnoy.bank.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ua.javaPro.berezhnoy.bank.person.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByUid(String id);
}
