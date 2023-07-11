package org.ua.javaPro.berezhnoy.bank.transaction;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TransactionDto(String from, String to, Amount amount, LocalDateTime createAt) {
}
