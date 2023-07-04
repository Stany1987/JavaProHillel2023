package org.ua.javaPro.berezhnoy.bank.controller;

import jakarta.xml.bind.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ua.javaPro.berezhnoy.bank.transaction.Transaction;
import org.ua.javaPro.berezhnoy.bank.transaction.TransactionDto;
import org.ua.javaPro.berezhnoy.bank.transaction.TransactionService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;


    @PostMapping("/transaction")
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto) {
        try {
            TransactionDto createdTransaction = transactionService.createTransaction(transactionDto);
            return ResponseEntity.ok(createdTransaction);
        } catch (ValidationException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        System.out.println(transaction);
        if (transaction != null) {
            return ResponseEntity.ok(transaction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

