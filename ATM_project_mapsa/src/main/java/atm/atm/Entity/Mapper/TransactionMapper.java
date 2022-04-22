package atm.atm.Entity.Mapper;

import atm.atm.Entity.DTO.TransactionDTO;
import atm.atm.Entity.Transaction;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface TransactionMapper extends IMapperAll<Transaction, TransactionDTO>{

}
