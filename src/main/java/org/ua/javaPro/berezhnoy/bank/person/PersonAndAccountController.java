package org.ua.javaPro.berezhnoy.bank.person;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ua.javaPro.berezhnoy.bank.account.AccountDto;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonAndAccountController {
    private final PersonAndAccountService personAndAccountService;

    @PostMapping
    public PersonDto createPerson(@RequestBody PersonDto person) {
        return personAndAccountService.create(person);
    }

    @GetMapping("/{id}")
    public PersonDto getPerson(@PathVariable("id") String id) {
        return personAndAccountService.findPerson(id);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") String id) {
        personAndAccountService.deletePerson(id);
    }

    @GetMapping("/iban/{iban}")
    public ResponseEntity<AccountDto> getAccountByIban(@PathVariable String iban) {
        try {
            AccountDto accountDto = personAndAccountService.findAccountByIban(iban);
            return ResponseEntity.ok(accountDto);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public PersonDto updatePerson(@PathVariable("id") String id, @RequestBody PersonDto person) {
        return personAndAccountService.updatePerson(id, person);
    }

    @PostMapping("/{personUid}/accounts")
    public ResponseEntity<AccountDto> createAccountForPerson(@PathVariable String personUid, @RequestBody AccountDto accountDto) {
        AccountDto createdAccount = personAndAccountService.createAccountForPerson(personUid, accountDto);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/{personUid}/accounts")
    public ResponseEntity<List<AccountDto>> personAccounts(@PathVariable String personUid) {
        List<AccountDto> accoounts = personAndAccountService.personAccaunts(personUid);
        return ResponseEntity.ok(accoounts);
    }

    @GetMapping("/accounts/{accountUid}")
    public ResponseEntity<AccountDto> account(@PathVariable("accountUid") String accountUid) {
        AccountDto accountDto = personAndAccountService.findAccount(accountUid);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/accounts/{accountUid}")
    public AccountDto updateAccountBalance(@PathVariable("accountUid") String accountUid, @RequestBody Long newBalance) {
        return personAndAccountService.updateAccountBalance(accountUid, newBalance);
    }

    @DeleteMapping("/{accountUid}/accounts")
    public void deleteAccount(@PathVariable("accountUid") String id) {
        personAndAccountService.deleteAccount(id);
    }
}
