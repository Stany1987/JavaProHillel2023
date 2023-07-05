package org.ua.javaPro.berezhnoy.bank.transaction;

import jakarta.xml.bind.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ua.javaPro.berezhnoy.bank.account.Account;
import org.ua.javaPro.berezhnoy.bank.account.AccountRepository;
import org.ua.javaPro.berezhnoy.bank.currency.CurrencyConverter;
import org.ua.javaPro.berezhnoy.bank.repository.TransactionRepository;

import java.util.Currency;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final CurrencyConverter currencyConverter;


    private TransactionDto mapTransactionToDto(Transaction transaction) {

        return new TransactionDto(
                transaction.getFromIban(),
                transaction.getToIban(),
                transaction.getAmount(),
                transaction.getCreateAt()
        );
    }

    @Transactional
    public TransactionDto createTransaction(TransactionDto transactionDto) throws ValidationException {
        Amount amount = transactionDto.amount();
        Optional<Account> optionalFromAccount = accountRepository.findByIban(transactionDto.from());
        Optional<Account> optionalToAccount = accountRepository.findByIban(transactionDto.to());
        Account fromAccount = optionalFromAccount.orElseThrow(() -> new NoSuchElementException("From account not found"));
        Account toAccount = optionalToAccount.orElseThrow(() -> new NoSuchElementException("To account not found"));

        if (fromAccount.getBalance() < transactionDto.amount().getValue()) {
            throw new ValidationException("Insufficient funds");
        }

        if (!fromAccount.getCurrency().equals(toAccount.getCurrency())) {
            System.out.println(fromAccount.getCurrency());
            System.out.println(toAccount.getCurrency());
            System.out.println(transactionDto.amount().getValue());
            Double convertedAmount = currencyConverter.convert(
                    Currency.getInstance(fromAccount.getCurrency()),
                    Currency.getInstance(toAccount.getCurrency()),
                    transactionDto.amount().getValue()
            );
            System.out.println(convertedAmount);

            if (fromAccount.getBalance() < convertedAmount) {
                throw new ValidationException("Insufficient funds");
            }
            fromAccount.setBalance((long) (fromAccount.getBalance() - amount.getValue()));
            toAccount.setBalance((long) (toAccount.getBalance() + convertedAmount));
        } else {
            if (fromAccount.getBalance() < transactionDto.amount().getValue()) {
                throw new ValidationException("Insufficient funds");
            }

            fromAccount.setBalance((long) (fromAccount.getBalance() - transactionDto.amount().getValue()));
            toAccount.setBalance((long) (toAccount.getBalance() + transactionDto.amount().getValue()));
        }

        var transaction = Transaction.builder()
                .fromIban(transactionDto.from())
                .toIban(transactionDto.to())
                .amount(transactionDto.amount())
                .createAt(LocalDateTime.now())
                .fromAccount(fromAccount)
                .toAccount(toAccount)
                .build();
        transactionRepository.save(transaction);

        return mapTransactionToDto(transaction);

    }

    public TransactionDto getTransactionById(Long transactionId) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(transactionId);
        return optionalTransaction.orElse(null);
    }
}
