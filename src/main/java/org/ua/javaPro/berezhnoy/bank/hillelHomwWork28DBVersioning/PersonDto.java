package org.ua.javaPro.berezhnoy.bank.hillelHomwWork28DBVersioning;

import lombok.Builder;

@Builder

public record PersonDto(long id, String uid, String name, String email) {

}
