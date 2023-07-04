package org.ua.javaPro.berezhnoy.bank.currency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Currency;
import java.util.Map;
@Slf4j
@Service
public class CurrencyApiCurrencyConverter implements CurrencyConverter {

    private final WebClient webClient;
    private final CurrencyProperties config;

    public CurrencyApiCurrencyConverter(CurrencyProperties config) {
        this.webClient = WebClient.builder().build();
        this.config = config;
    }

    @Override
    public double convert(Currency from, Currency to, double amount) {

        try {
            var result = webClient.get()
                    .uri(config.getUrl(), uri -> uri.queryParam("apikey", config.getKey())
                            .queryParam("base_currency", from)
                            .queryParam("currencies", to)
                            .build())
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();
            log.info("api"+result);
            Map<String, Object> data = (Map<String, Object>) result.get("data");
            System.out.println("Data: " + data);
            Map<String, Object> currencyData = (Map<String, Object>) data.get(to.toString());
            System.out.println("Currency Data: " + currencyData);
            Double value = ((Number) currencyData.get("value")).doubleValue();
            System.out.println("Conversion Rate: " + value);
            return amount * value;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Currency conversion error");
        }
    }

}
