package org.ua.javaPro.berezhnoy.bank.transaction;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ua.javaPro.berezhnoy.bank.account.Account;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    @JsonIgnore
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    @JsonIgnore
    private Account toAccount;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "amount_value")),
            @AttributeOverride(name = "currency", column = @Column(name = "amount_currency"))
    })
    private Amount amount;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(name = "from_iban", nullable = false, length = 20)
    private String fromIban;

    @Column(name = "to_iban", nullable = false, length = 20)
    private String toIban;

}
