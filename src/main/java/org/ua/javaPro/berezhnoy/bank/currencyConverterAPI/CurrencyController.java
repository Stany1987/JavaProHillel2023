package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.Map;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyConverter currencyConverter;

    @GetMapping("/convert")
    public Object convert(
            @RequestParam("from") Currency from,
            @RequestParam("to") Currency to,
            @RequestParam("amount") Integer amount
    ) {
        return Map.of("value", currencyConverter.convert(from, to, amount));

    }

}
