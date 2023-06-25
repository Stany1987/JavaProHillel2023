package org.ua.javaPro.berezhnoy.bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.ua.javaPro.berezhnoy.bank.account.Account;
import org.ua.javaPro.berezhnoy.bank.account.AccountDto;
import org.ua.javaPro.berezhnoy.bank.account.AccountRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonAndAccountService {

    private final PersonRepository personRepository;
    private final AccountRepository accountRepository;

    public PersonDto findPerson(String id) {
        return personRepository.findByUid(id)
                .map(this::mapPersonToDto)
                .orElseThrow(() -> new NoSuchElementException("Person not found : " + id));
    }

    public PersonDto create(PersonDto person) {
        var savedPerson = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name(person.name())
                .email(person.email())
                .build());
        return mapPersonToDto(savedPerson);
    }

    public void deletePerson(String uid) {
        var person = personRepository.findByUid(uid).orElseThrow();
        personRepository.delete(person);
    }

    public PersonDto updatePerson(String uid, PersonDto person) {
        var personToUpdate = personRepository.findByUid(uid).orElseThrow();
        personToUpdate.setName(person.name());
        personToUpdate.setEmail(person.email());
        return mapPersonToDto(personRepository.save(personToUpdate));
    }

    private PersonDto mapPersonToDto(Person person) {
        return PersonDto.builder()
                .id(person.getId())
                .uid(person.getUid())
                .name(person.getName())
                .email(person.getEmail())
                .build();
    }


    public AccountDto createAccountForPerson(String personUid, AccountDto accountDto) {
        var person = personRepository.findByUid(personUid)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));

        Account account = Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban(accountDto.iban())
                .balance(accountDto.balance())
                .currency(accountDto.currency())
                .person(person)
                .build();

        Account savedAccount = accountRepository.save(account);
        return mapAccountToDto(savedAccount);
    }

    public AccountDto findAccount(String id) {
        return accountRepository.findByUid(id)
                .map(this::mapAccountToDto)
                .orElseThrow(() -> new NoSuchElementException("Account not fund " + id));
    }

    public List<AccountDto> personAccaunts(String personUid) {
        var person = personRepository.findByUid(personUid)
                .orElseThrow(() -> new NoSuchElementException("Person not found uid " + personUid));
        List<Account> accounts = accountRepository.findByPerson(person);
        return accounts.stream()
                .map(this::mapAccountToDto)
                .collect(Collectors.toList());
    }

    public AccountDto updateAccountBalance(String accountUid, Long newBalance) {
        Account accountToUpdate = accountRepository.findByUid(accountUid)
                .orElseThrow(() -> new NoSuchElementException("Account not found " + accountUid));
        accountToUpdate.setBalance(newBalance);
        return mapAccountToDto(accountRepository.save(accountToUpdate));

    }


    public void deleteAccount(String uid) {
        Account account = accountRepository.findByUid(uid).orElseThrow();
        accountRepository.delete(account);
    }

    private AccountDto mapAccountToDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .uid(account.getUid())
                .iban(account.getIban())
                .balance(account.getBalance())
                .currency(account.getCurrency())
                .personUid(account.getPerson().getUid())
                .build();
    }


}

