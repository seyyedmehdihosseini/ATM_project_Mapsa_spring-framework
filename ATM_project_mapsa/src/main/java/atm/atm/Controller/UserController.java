package atm.atm.Controller;

import atm.atm.Entity.Users;
import atm.atm.Service.IUserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private IUserService service ;

    @PostMapping("/user/add")
    public ResponseEntity<?> createdUser(@RequestBody Users user){
      if (!service.existUserByUsername(user.getUsername())){
          if (user.getUsername().length()>9 && user.getUsername().length()<12){
              if (user.getPassword().length()>6 && user.getPassword().length()<13){
                  Users created = service.created(user);
                  return new ResponseEntity<>(created,HttpStatus.CREATED);
              }else {
                  return ResponseEntity.badRequest().body("length password is not match ");
              }
          }else {
              return ResponseEntity.badRequest().body("length username is not match");
          }
      }else {
          return ResponseEntity.badRequest().body("username is found by username in dataBase");
      }
    }


    @PutMapping("/user")
    public ResponseEntity<?> findUser(String username){
        if (service.existUserByUsername(username)){
            Users usersByUsername = service.findUsersByUsername(username);
            return new ResponseEntity<>(usersByUsername,HttpStatus.OK);
        }else {
            return ResponseEntity.badRequest().body("username is not found");
        }
    }


    @GetMapping("/user/findAllUser")
    public ResponseEntity<?> findAllUser(){
        List<Users> all = service.findAll();
        if (all.size()>0){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user is null");
        }
    }

}
