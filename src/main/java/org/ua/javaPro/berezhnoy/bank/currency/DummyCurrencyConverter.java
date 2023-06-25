package org.ua.javaPro.berezhnoy.bank.currency;

import org.ua.javaPro.berezhnoy.bank.currency.CurrencyConverter;

import java.util.Currency;

public class DummyCurrencyConverter implements CurrencyConverter {
    private static final double CONVERSION_RATE = 37.20;

    @Override
    public double convert(Currency from, Currency to, double amount) {

        return amount * CONVERSION_RATE;
    }
}
