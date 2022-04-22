package atm.atm.Entity.DTO;

import atm.atm.Entity.Account;
import atm.atm.enums.TransactionType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
@Data
public class TransactionDTO {

    private TransactionType type;

    private Long amount;

    private Date date;

    private AccountDTO account;


}
