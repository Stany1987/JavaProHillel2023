package org.ua.javaPro.berezhnoy.bank.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ua.javaPro.berezhnoy.bank.user.UsersData;

import java.util.List;

@Repository
public interface UsersDataRepository extends JpaRepository<UsersData, Long> {
    List<UsersData> findByName(String name);

    List<UsersData> findByEmail(String email);

    List<UsersData> findAll();


}
