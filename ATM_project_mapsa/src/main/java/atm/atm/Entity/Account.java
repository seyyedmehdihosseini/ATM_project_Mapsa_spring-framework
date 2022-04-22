package atm.atm.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tbl_accounts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private Long accountNumber;

    private Long amount;// we must use BigDecimal or use Double and valueOf in BigDecimal

    @ManyToOne(fetch = FetchType.EAGER , cascade =  CascadeType.ALL)
    @JoinColumn(name = "username" , referencedColumnName = "username")
    private Users users ;


    @ManyToMany(mappedBy = "account" , cascade = CascadeType.ALL)
    private List<Transaction> transactions;


}
