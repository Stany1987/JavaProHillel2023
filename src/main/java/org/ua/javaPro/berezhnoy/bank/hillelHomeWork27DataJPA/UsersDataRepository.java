package org.ua.javaPro.berezhnoy.bank.hillelHomeWork27DataJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDataRepository extends JpaRepository<UsersData, Long> {
    List<UsersData> findByName(String name);

    List<UsersData> findByEmail(String email);

    List<UsersData> findAll();


}
