package atm.atm.Service;

import atm.atm.Entity.Users;
import atm.atm.Exception_Handling.NotFoundException;
import atm.atm.Repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private IUserRepository repository;


    @Override
    public Users created(Users user) {
        return repository.save(user);
    }

    @Override
    public Boolean existUserByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Users findUsersByUsername(String username) {
        return repository.findUsersByUsername(username);
    }

    @Override
    public Users update(Users users) {
        return null;
    }

    @Override
    public Users findByUnique(String username) {
        if (repository.existsByUsername(username)) {
            return repository.findUsersByUsername(username);
        }else {
            throw new NotFoundException("id is not found ");
        }
    }

    @Override
    public void deleteByUnique(String username) {
        if (repository.existsByUsername(username)){
            Users usersByUsername = repository.findUsersByUsername(username);
            repository.deleteById(usersByUsername.getId());
        }else {
            throw new NotFoundException("id is not found ");
        }
    }

    @Override
    public List<Users> findAll() {
        return (List<Users>) repository.findAll();
    }

}
/*
    private IUserRepository repository;


    @Override
    public Users update(Users users) {
        if (repository.existsByUsername(users.getUsername())){
            Users usersByUsername = repository.findUsersByUsername(users.getUsername());
            usersByUsername.setPassword(users.getPassword());
            usersByUsername.setDisplayName(users.getDisplayName());
            return repository.save(usersByUsername);
        }else {
            throw new NotFoundException("username is not found");
        }
    }

    @Override
    public Users findById(Long id) {
        if (repository.existsById(id)){
            Optional<Users> byId = repository.findById(id);
            return byId.get();
        }else {
            throw new NotFoundException("id is not found");
        }
    }

    @Override
    public void deleteById(Long id) {
        // not delete user because users is empty in dataBase
    }

    @Override
    public List<Users> findAll() {
        Iterable<Users> all = repository.findAll();
       if (all!=null){
           return (List<Users>) all;
       }else {
        throw new NotFoundException("number is not found");
       }
    }

    @Override
    public Users created(Users user) {
        if (!repository.existsByUsername(user.getUsername())){
            if (user.getPassword().length()>6 && user.getPassword().length()<13){
                return repository.save(user);
            }else {
                throw new NotFoundException("password error");
            }
        }else {
            throw new ConflictException("username is conflict");
        }
    }

    @Override
    public Boolean existUserByUsername(String username) {
        if (username.length()==10){
            return repository.existsByUsername(username);
        }
        else {
            throw new NotFoundException("username is not found");
        }
    }

    @Override
    public Users findUsersByUsername(String username) {
       if (username.length()==10){
           return repository.findUsersByUsername(username);
       }else {
           throw new NotFoundException("username is not found");
       }
    }*/