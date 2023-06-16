package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfig {
    @Bean
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "dummy", matchIfMissing = true)
    public CurrencyConverter dummyCurrencyConverter() {
        return new DummyCurrencyConverter();
    }

    @Bean
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "currencyapi")
    public CurrencyConverter currencyApiCurrencyConverter(PropCurrency config) {
        return new CurrencyApiCurrencyConverter(config);
    }
}
