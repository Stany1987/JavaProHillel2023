package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import java.util.Currency;

public interface CurrencyConverter {
    public double convert(Currency from, Currency to, double amount);
}
