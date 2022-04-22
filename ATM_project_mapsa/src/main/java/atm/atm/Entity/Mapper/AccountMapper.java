package atm.atm.Entity.Mapper;

import atm.atm.Entity.Account;
import atm.atm.Entity.DTO.AccountDTO;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring" )
public interface AccountMapper extends IMapperAll<Account, AccountDTO>{
}