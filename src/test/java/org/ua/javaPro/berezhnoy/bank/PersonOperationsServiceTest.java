package org.ua.javaPro.berezhnoy.bank;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.ua.javaPro.berezhnoy.bank.currencyConverterAPI.CurrencyConverter;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class PersonOperationsServiceTest {
    @Mock
    private CurrencyConverter currencyConverter;

    @InjectMocks
    private PersonOperationsService personOperationsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldConvertCurrencySuccessfully() throws Exception {

        Currency fromCurrency = Currency.getInstance("UAH");
        Currency toCurrency = Currency.getInstance("USD");
        double amount = 10;
        double expectedAmount = 15.0;

        when(currencyConverter.convert(fromCurrency, toCurrency, amount)).thenReturn(expectedAmount);

        CompletableFuture<Double> resultFuture = personOperationsService.convert(fromCurrency, toCurrency, amount);
        double convertedAmount = resultFuture.get();

        assertEquals(expectedAmount, convertedAmount, 0.0);
        log.info("{},{}", expectedAmount, convertedAmount);
    }
}






