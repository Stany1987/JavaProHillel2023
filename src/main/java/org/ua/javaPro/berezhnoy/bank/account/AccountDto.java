package org.ua.javaPro.berezhnoy.bank.account;

import lombok.Builder;

@Builder
public record AccountDto(long id, String uid, String iban, Long balance, String personUid) {

}
