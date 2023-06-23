package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CurrencyConfig {
    @Bean(name = "dummyCurrencyConverter")
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "dummy", matchIfMissing = false)
    public CurrencyConverter dummyCurrencyConverter() {
        return new DummyCurrencyConverter();
    }

    @Bean(name = "currencyApiCurrencyConverter")
    @ConditionalOnProperty(name = "currency.converter.provider", havingValue = "currencyapi")
    public CurrencyConverter currencyApiCurrencyConverter(CurrencyProperties config) {
        return new CurrencyApiCurrencyConverter(config);
    }
}
