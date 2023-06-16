package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class CurrencyApiCurrencyConverter implements CurrencyConverter {

    private final WebClient webClient;
    private final PropCurrency config;

    public CurrencyApiCurrencyConverter(PropCurrency config) {
        this.webClient = WebClient.builder().build();
        this.config = config;
    }

    @Override
    public double convert(String from, String to, double amount) {

        try {
            var result = webClient.get()
                    .uri(config.getUrl(), uri -> uri.queryParam("apikey", config.getKey())
                            .queryParam("base_currency", from)
                            .queryParam("currencies", to)
                            .build())
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            Map<String, Object> data = (Map<String, Object>) result.get("data");
            Map<String, Object> uahData = (Map<String, Object>) data.get(to);
            Double value = (Double) uahData.get("value");
            return amount * value;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
