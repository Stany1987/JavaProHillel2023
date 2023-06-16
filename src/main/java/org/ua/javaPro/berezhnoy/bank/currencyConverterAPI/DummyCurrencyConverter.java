package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

public class DummyCurrencyConverter implements CurrencyConverter {
    private static final double CONVERSION_RATE = 37.20;

    @Override
    public double convert(String from, String to, double amount) {

        return amount * CONVERSION_RATE;
    }
}
