package atm.atm.Entity.DTO;

import atm.atm.Entity.Users;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class AccountDTO {

    @NotNull
    @Size(min = 10 , max = 17)
    private Long accountNumber;

    @NotNull
    private Double amount;

    private Users users ;

}
