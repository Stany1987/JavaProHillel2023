package org.ua.javaPro.berezhnoy.bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.ua.javaPro.berezhnoy.bank.account.Account;
import org.ua.javaPro.berezhnoy.bank.account.AccountRepository;
import org.ua.javaPro.berezhnoy.bank.person.Person;
import org.ua.javaPro.berezhnoy.bank.person.PersonRepository;
import org.ua.javaPro.berezhnoy.bank.transaction.Amount;
import org.ua.javaPro.berezhnoy.bank.transaction.Transaction;
import org.ua.javaPro.berezhnoy.bank.transaction.TransactionDto;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TransactionControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeAll
    static void setup(@Autowired PersonRepository personRepository, @Autowired AccountRepository accountRepository) {
        Person firstPerson = Person.builder()
                .uid("7777")
                .name("Test1")
                .email("Test@test.com")
                .build();
        personRepository.save(firstPerson);


        Person secondPerson = Person.builder()
                .uid("8888")
                .name("Test2")
                .email("Test2@test.com")
                .build();
        personRepository.save(secondPerson);

        Account fromAccount = Account.builder()
                .uid(UUID.randomUUID().toString())
                .iban("1111")
                .balance(1000L)
                .person(firstPerson)
                .currency("UAH")
                .build();

        Account toAccount = Account.builder()
                .uid(String.valueOf(UUID.randomUUID()))
                .iban("2222")
                .balance(500L)
                .person(secondPerson)
                .currency("UAH")
                .build();

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }

    @Test
    public void testCreateTransaction() throws Exception {
        Amount amount = new Amount(100.0, "UAH");
        TransactionDto transactionDto = new TransactionDto("1111", "2222", amount, LocalDateTime.now());

        mockMvc.perform(MockMvcRequestBuilders.post("/api/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transactionDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.from").value("1111"))
                .andExpect(jsonPath("$.to").value("2222"))
                .andExpect(jsonPath("$.amount.value").value(100.0));
    }


    @Test
    public void testGetTransactionById() throws Exception {
        Amount amount = new Amount(100.0, "UAH");
        TransactionDto transactionDto = new TransactionDto("1111", "2222", amount, LocalDateTime.now());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/transaction")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transactionDto)))
                .andExpect(status().isOk());


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/{id}", 1L))
                .andExpect(status().isOk())
                .andReturn();

        String responseJson = mvcResult.getResponse().getContentAsString();
        Transaction transaction = objectMapper.readValue(responseJson, Transaction.class);

        assertEquals("1111", transaction.getFromIban());
        assertEquals("2222", transaction.getToIban());
        assertEquals(100.0, transaction.getAmount().getValue(), 0.01);
    }

}
