package org.ua.javaPro.berezhnoy.bank.hillelHomwWork28DBVersioning;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUid(String id);

    List<Account> findByPerson(Person person);
}
