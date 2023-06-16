package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DummyCurrencyConverterTest {
    @Test
    public void testConvert() {


        CurrencyConverter converter = new DummyCurrencyConverter();
        double amount = 105;
        double expectedAmount = amount * 37.20;
        double convertedAmount = converter.convert("USD", "UAH", amount);

        assertEquals(expectedAmount, convertedAmount);

    }
}