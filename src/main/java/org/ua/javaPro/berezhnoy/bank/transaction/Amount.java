package org.ua.javaPro.berezhnoy.bank.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Amount {
    private Double value;
    private String currency;
}
