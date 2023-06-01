package org.ua.javaPro.berezhnoy.bank.hillelHomwWork28DBVersioning;

import lombok.Builder;

@Builder
public record AccountDto(long id, String uid, String iban, Long balance, String personUid) {

}
