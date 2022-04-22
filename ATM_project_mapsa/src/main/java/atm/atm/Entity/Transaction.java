package atm.atm.Entity;

import atm.atm.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_transactions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private Long amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToMany
    @JoinTable(
            name = "transactions_tbl_accounts",
            joinColumns =
                    {@JoinColumn(name = "transactions") },
            inverseJoinColumns =
                    {@JoinColumn(name = "account" )}
    )
    @NotNull
    private List<Account> account;


}
