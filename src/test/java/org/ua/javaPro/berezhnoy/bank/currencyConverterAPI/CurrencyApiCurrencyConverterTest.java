package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class CurrencyApiCurrencyConverterTest {
    @Value("${currency.url}")
    private String currencyUrl;

    @Value("${currency.apikey}")
    private String currencyApiKey;

    private CurrencyApiCurrencyConverter currencyConverter;

    @BeforeEach
    public void setUp() {
        CurrencyProperties config = new CurrencyProperties();
        config.setUrl(currencyUrl);
        config.setKey(currencyApiKey);

        currencyConverter = new CurrencyApiCurrencyConverter(config);
    }

    @Test
    public void testCurrencyConversion() {
        Currency currencyFrom = Currency.getInstance("USD");
        Currency currencyTo = Currency.getInstance("UAH");
        double amount = 100.0;

        double convertedAmount = currencyConverter.convert(currencyFrom, currencyTo, amount);

        double expectedAmount = 3689.8309;
        assertEquals(expectedAmount, convertedAmount, 0.01);
    }
}
