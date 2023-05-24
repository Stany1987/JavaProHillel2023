package org.ua.javaPro.berezhnoy.bank.hillelHomeWork27DataJPA;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersService implements CommandLineRunner {
    private final UsersDataRepository userDataRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        UsersData john = UsersData.builder().uid((UUID.randomUUID().toString())).name("John")
                .email("John@gmail.com").role(UserRole.ADMIN.name()).build();
        UsersData kim = UsersData.builder().uid((UUID.randomUUID().toString())).name("Kim")
                .email("Kim@Gmail.com").role(UserRole.CUSTOMER.name()).build();

        userDataRepository.save(john);
        userDataRepository.save(kim);

        System.out.println(userDataRepository.findAll());
        System.out.println(userDataRepository.findByEmail("John@gmail.com"));
        System.out.println(userDataRepository.findByName("John"));
        System.out.println(userDataRepository.findById(10L));

        kim = userDataRepository.findById(11L).orElseThrow();
        kim.setRole(UserRole.CUSTOMER.name());
        userDataRepository.save(kim);

        userDataRepository.deleteById(9L);

    }
}
