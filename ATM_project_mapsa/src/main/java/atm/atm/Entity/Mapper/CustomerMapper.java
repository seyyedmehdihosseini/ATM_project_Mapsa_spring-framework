package atm.atm.Entity.Mapper;

import atm.atm.Entity.Users;
import atm.atm.Entity.DTO.UsersDTO;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring")
public interface CustomerMapper extends IMapperAll<Users, UsersDTO>{
}