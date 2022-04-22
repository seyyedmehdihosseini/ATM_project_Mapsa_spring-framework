package atm.atm.Entity.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UsersDTO {

    @Size(min = 2 , max = 20)
    @NotNull
    private String firstname;

    @Size(min = 3 , max = 20)
    @NotNull
    private String lastname;

    @NotNull
    @Size(min = 8,max = 12)
    private String username;

    @NotNull
    @Size(min = 6,max = 12 , message = "password numbers ... ")
    private String password;

}
