package org.ua.javaPro.berezhnoy.bank.account;


import org.springframework.data.jpa.repository.JpaRepository;
import org.ua.javaPro.berezhnoy.bank.person.Person;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUid(String id);

    List<Account> findByPerson(Person person);

    Optional<Account> findByIban(String iban);
}
