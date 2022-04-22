package atm.atm.Service;

import atm.atm.Entity.Users;

import java.util.List;

public interface IUserService extends CRUD<Users,String>{
    public Users created(Users user);
    public Boolean existUserByUsername(String username);
    public Users findUsersByUsername(String username);

}
