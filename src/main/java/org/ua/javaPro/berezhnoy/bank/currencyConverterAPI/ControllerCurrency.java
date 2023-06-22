package org.ua.javaPro.berezhnoy.bank.currencyConverterAPI;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.Map;
@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class ControllerCurrency {
    private final CurrencyConverter currencyConverter;


    @GetMapping("/convert")
    public Object convert(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("amount") Integer amount
    ) {
        Currency currencyFrom = Currency.getInstance(from);
        Currency currencyTo = Currency.getInstance(to);

        return Map.of("value", currencyConverter.convert(currencyFrom, currencyTo, amount));

    }

//    @GetMapping("/convert")
//    public Object convertCurrency(@RequestParam("from") String fromCurrency,
//                                  @RequestParam("to") String toCurrency,
//                                  @RequestParam("amount") double amount) {
//        Currency from = Currency.getInstance(fromCurrency);
//        Currency to = Currency.getInstance(toCurrency);
//
//        return Map.of("value", currencyConverter.convert(from, to, amount));
//
//    }






//    @GetMapping("/convert")
//    public Object convert(
//            @RequestParam("from") Currency from,
//            @RequestParam("to") Currency to,
//            @RequestParam("amount") Integer amount
//    ) {
//        return Map.of("value", currencyConverter.convert(from, to, amount));
//    }
}
