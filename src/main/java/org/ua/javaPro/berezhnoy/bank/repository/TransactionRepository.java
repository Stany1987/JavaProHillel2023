package org.ua.javaPro.berezhnoy.bank.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.ua.javaPro.berezhnoy.bank.transaction.Transaction;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    Optional<Transaction> findById(Long id);

}
