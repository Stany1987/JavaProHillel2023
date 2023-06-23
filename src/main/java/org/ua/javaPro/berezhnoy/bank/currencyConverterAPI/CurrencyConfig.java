package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfig {

    @Configuration
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "currecyapi")
    public static class currencyApiCurrencyConverter {
        @Bean
        public CurrencyConverter currencyConverter(CurrencyProperties currencyProperties) {
            return new CurrencyApiCurrencyConverter(currencyProperties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "dummy")
    public static class dummyCurrencyConverter {
        @Bean
        public CurrencyConverter currencyConverter() {
            return new DummyCurrencyConverter();
        }
    }
}
